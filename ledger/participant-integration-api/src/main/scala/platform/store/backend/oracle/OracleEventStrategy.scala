// Copyright (c) 2021 Digital Asset (Switzerland) GmbH and/or its affiliates. All rights reserved.
// SPDX-License-Identifier: Apache-2.0

package com.daml.platform.store.backend.oracle

import com.daml.lf.data.Ref
import com.daml.platform.store.backend.EventStorageBackend.FilterParams
import com.daml.platform.store.backend.common.ComposableQuery.{CompositeSql, SqlStringInterpolation}
import com.daml.platform.store.backend.common.EventStrategy
import com.daml.platform.store.interning.StringInterning

object OracleEventStrategy extends EventStrategy {

  override def filteredEventWitnessesClause(
      witnessesColumnName: String,
      parties: Set[Ref.Party],
      stringInterning: StringInterning,
  ): CompositeSql = {
    val internedParties =
      parties.view.map(stringInterning.party.tryInternalize).flatMap(_.toList).toSet
    internedParties.size match {
      case 0 => cSQL"json_array()"
      case 1 => cSQL"(json_array(${internedParties.head}))"
      case _ =>
        cSQL"""
           (select json_arrayagg(value) from (select value
           from json_table(#$witnessesColumnName, '$$[*]' columns (value NUMBER PATH '$$'))
           where value IN ($internedParties)))
           """
    }
  }

  override def submittersArePartiesClause(
      submittersColumnName: String,
      parties: Set[Ref.Party],
      stringInterning: StringInterning,
  ): CompositeSql =
    OracleQueryStrategy.arrayIntersectionNonEmptyClause(
      submittersColumnName,
      parties,
      stringInterning,
    )

  override def witnessesWhereClause(
      witnessesColumnName: String,
      filterParams: FilterParams,
      stringInterning: StringInterning,
  ): CompositeSql = {
    val wildCardClause = filterParams.wildCardParties match {
      case wildCardParties
          if wildCardParties.isEmpty ||
            wildCardParties.view
              .flatMap(party => stringInterning.party.tryInternalize(party).toList)
              .isEmpty =>
        Nil

      case wildCardParties =>
        cSQL"(${OracleQueryStrategy.arrayIntersectionNonEmptyClause(witnessesColumnName, wildCardParties, stringInterning)})" :: Nil
    }
    val partiesTemplatesClauses =
      filterParams.partiesAndTemplates.iterator
        .map { case (parties, templateIds) =>
          (
            parties.flatMap(s => stringInterning.party.tryInternalize(s).toList),
            templateIds.flatMap(s => stringInterning.templateId.tryInternalize(s).toList),
          )
        }
        .filterNot(_._1.isEmpty)
        .filterNot(_._2.isEmpty)
        .map { case (parties, templateIds) =>
          val clause =
            OracleQueryStrategy.arrayIntersectionNonEmptyClause(
              witnessesColumnName,
              parties.map(stringInterning.party.externalize),
              stringInterning,
            )
          cSQL"( ($clause) AND (template_id IN ($templateIds)) )"
        }
        .toList
    wildCardClause ::: partiesTemplatesClauses match {
      case Nil => cSQL"1 = 0"
      case allClauses => allClauses.mkComposite("(", " OR ", ")")
    }
  }
}
