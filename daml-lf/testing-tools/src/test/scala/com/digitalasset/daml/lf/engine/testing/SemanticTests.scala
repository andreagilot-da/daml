// Copyright (c) 2019 Digital Asset (Switzerland) GmbH and/or its affiliates. All rights reserved.
// SPDX-License-Identifier: Apache-2.0

package com.digitalasset.daml.lf.engine.testing

import com.digitalasset.daml.lf.archive.{Decode, UniversalArchiveReader}
import com.digitalasset.daml.bazeltools.BazelRunfiles
import com.digitalasset.daml.lf.language.Ast.{DValue, Package}
import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}
import org.scalatest.time.{Millis, Span}
import org.scalatest.{Matchers, WordSpec}
import java.io.File

import scala.concurrent.ExecutionContext.Implicits.global

class SemanticTests
    extends WordSpec
    with Matchers
    with ScalaFutures
    with IntegrationPatience
    with BazelRunfiles {
  val loader = Thread.currentThread().getContextClassLoader()

  // these files are generated by bazel. Add new tests here.

  val darFiles = List(
    "daml-lf/tests/BasicTests.dar",
    "daml-lf/tests/AuthorizedDivulgence.dar",
    "daml-lf/tests/DontDiscloseNonConsumingChoicesToObservers.dar",
    "daml-lf/tests/LargeTransaction.dar",
  )

  val testPackages = darFiles.map(file => {
    val packages =
      UniversalArchiveReader().readFile(new File(rlocation(file))).get
    val packagesMap = Map(packages.all.map {
      case (pkgId, pkgArchive) => Decode.readArchivePayloadAndVersion(pkgId, pkgArchive)._1
    }: _*)
    val (mainPkgId, mainPkgArchive) = packages.main
    val mainPkg = Decode.readArchivePayloadAndVersion(mainPkgId, mainPkgArchive)._1._2
    (mainPkgId, mainPkg, packagesMap)
  })

  def countTests(pkg: Package): Int = {
    val modules = pkg.modules.values
    modules.foldLeft(0) {
      case (count, module) =>
        count + module.definitions.collect {
          case (_, DValue(_, _, _, isTest)) if isTest => 1
        }.sum
    }
  }

  // TODO (drsk): We need to test daml 1.2 packages separate, because we can not mix 1.x packages
  // with 1.2 packages. Merge this with the above tests once we retire 1.x.
  testPackages.foreach {
    case (pkgId, pkg, allPackages) =>
      val testCount = countTests(pkg)
      s"run $testCount scenarios $pkgId in engine" should {
        "complete" in {
          assert(testCount > 0)
          val semanticTester =
            new SemanticTester(
              _ => new SemanticTester.EngineLedger(allPackages),
              pkgId,
              allPackages)
          // NOTE(JM, SC): default 15 second timeout (assuming that comfortably
          // fits any constant factors), and we broke 30s around 400 market infrastructure
          // scenarios; 50ms/test would give us 35s for 400, 75 gives us 45s,
          // which seems like a good margin. 60s ceiling as "don't go too crazy"
          // factor

          // NOTE(GYF): increased the timeouts because post-commit validation is running
          // for each party sequentially for each transaction
          // the ceiling is now 4 minutes
          // the base is 30 seconds and each test is estimated to be 150ms

          // NOTE(MH): 10x to make Bazel CI happy
          val waitMillis = 240000L min (30000L + 150L * testCount) * 10
          implicit val patienceConfig: PatienceConfig =
            this.patienceConfig copy (timeout = scaled(Span(waitMillis, Millis)))
          whenReady(semanticTester.testAllScenarios()) { _ =>
            succeed
          }
        }
      }
  }
}
