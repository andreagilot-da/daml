# Copyright (c) 2023 Digital Asset (Switzerland) GmbH and/or its affiliates. All rights reserved.
# SPDX-License-Identifier: Apache-2.0

load("//daml-lf/language:daml-lf.bzl", "versions")

def deps(lf_version):
    carbon_tests = [
        "//test-common:carbonv1-tests-%s.scala" % lf_version,
        "//test-common:carbonv2-tests-%s.scala" % lf_version,
        "//test-common:carbonv3-tests-%s.scala" % lf_version,
    ]
    model_tests = ["//test-common:modelext-tests-%s.scala" % lf_version]
    additional_tests = carbon_tests + model_tests if (versions.gte(lf_version, "1.15")) else []
    return [
        "//daml-lf/data",
        "//daml-lf/transaction",
        "//language-support/scala/bindings",
        "//ledger/error",
        "//ledger/ledger-api-errors",
        "//ledger/ledger-api-common",
        "//ledger-test-tool/infrastructure:infrastructure-%s" % lf_version,
        "//libs-scala/ledger-resources",
        "//libs-scala/test-evidence/tag:test-evidence-tag",
        "//test-common:dar-files-%s-lib" % lf_version,
        "//test-common:model-tests-%s.scala" % lf_version,
        "//test-common:package_management-tests-%s.scala" % lf_version,
        "//test-common:semantic-tests-%s.scala" % lf_version,
        "//test-common:test-common-%s" % lf_version,
        "//libs-scala/contextualized-logging",
        "//libs-scala/grpc-utils",
        "//libs-scala/resources",
        "//libs-scala/resources-akka",
        "//libs-scala/resources-grpc",
        "//libs-scala/timer-utils",
        "@maven//:com_google_api_grpc_proto_google_common_protos",
        "@maven//:io_grpc_grpc_api",
        "@maven//:io_grpc_grpc_netty",
        "@maven//:io_netty_netty_handler",
        "@maven//:org_slf4j_slf4j_api",
    ] + additional_tests
