# Security tests, by category

## Authorization:
- auth and auth-* should not be set together for the trigger service: [CliConfigTest.scala](triggers/service/src/test-suite/scala/com/daml/lf/engine/trigger/CliConfigTest.scala#L40)
- badly-authorized create is rejected: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L70)
- badly-authorized exercise is rejected: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L171)
- badly-authorized exercise/create (create is unauthorized) is rejected: [AuthPropagationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthPropagationSpec.scala#L257)
- badly-authorized exercise/create (exercise is unauthorized) is rejected: [AuthPropagationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthPropagationSpec.scala#L225)
- badly-authorized exercise/exercise (no implicit authority from outer exercise) is rejected: [AuthPropagationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthPropagationSpec.scala#L316)
- badly-authorized fetch is rejected: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L105)
- badly-authorized lookup is rejected: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L128)
- create with no signatories is rejected: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L60)
- create with non-signatory maintainers is rejected: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L82)
- error on specifying both authCommonUri and authInternalUri/authExternalUri for the trigger service: [AuthorizationConfigTest.scala](triggers/service/src/test-suite/scala/com/daml/lf/engine/trigger/AuthorizationConfigTest.scala#L24)
- error on specifying only authInternalUri and no authExternalUri for the trigger service: [AuthorizationConfigTest.scala](triggers/service/src/test-suite/scala/com/daml/lf/engine/trigger/AuthorizationConfigTest.scala#L52)
- exercise with no controllers is rejected: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L161)
- well-authorized create is accepted: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L53)
- well-authorized exercise is accepted: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L154)
- well-authorized exercise/create is accepted: [AuthPropagationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthPropagationSpec.scala#L203)
- well-authorized exercise/exercise is accepted: [AuthPropagationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthPropagationSpec.scala#L359)
- well-authorized fetch is accepted: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L99)
- well-authorized lookup is accepted: [AuthorizationSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/AuthorizationSpec.scala#L121)

## Availability:
- Tail call optimization: Tail recursion does not blow the scala JVM stack.: [TailCallTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/TailCallTest.scala#L16)

## Confidentiality:
- ensure correct privacy for create node: [BlindingSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/BlindingSpec.scala#L38)
- ensure correct privacy for exercise node (consuming): [BlindingSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/BlindingSpec.scala#L50)
- ensure correct privacy for exercise node (non-consuming): [BlindingSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/BlindingSpec.scala#L71)
- ensure correct privacy for exercise subtree: [BlindingSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/BlindingSpec.scala#L149)
- ensure correct privacy for fetch node: [BlindingSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/BlindingSpec.scala#L93)
- ensure correct privacy for lookup-by-key node (found): [BlindingSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/BlindingSpec.scala#L106)
- ensure correct privacy for lookup-by-key node (not-found): [BlindingSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/BlindingSpec.scala#L127)
- ensure correct privacy for rollback subtree: [BlindingSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/BlindingSpec.scala#L224)

## Integrity:
- Evaluation order of create with authorization failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L572)
- Evaluation order of create with contract ID in contract key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L595)
- Evaluation order of create with contract key exceeding max nesting: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L648)
- Evaluation order of create with create argument exceeding max nesting: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L622)
- Evaluation order of create with duplicate contract key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L521)
- Evaluation order of create with empty contract key maintainers: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L546)
- Evaluation order of create with failed precondition: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L503)
- Evaluation order of create_interface with authorization failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L774)
- Evaluation order of create_interface with contract ID in contract key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L797)
- Evaluation order of create_interface with contract key exceeding max nesting: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L850)
- Evaluation order of create_interface with create argument exceeding max nesting: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L824)
- Evaluation order of create_interface with duplicate contract key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L723)
- Evaluation order of create_interface with empty contract key maintainers: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L748)
- Evaluation order of create_interface with failed precondition: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L703)
- Evaluation order of exercise by interface of a cached global contract that does not implement the interface.: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1809)
- Evaluation order of exercise by interface of an inactive global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1791)
- Evaluation order of exercise by interface of cached global contract with failed authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1851)
- Evaluation order of exercise of a cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1166)
- Evaluation order of exercise of a non-cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L923)
- Evaluation order of exercise of a non-cached global contract with inconsistent key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L948)
- Evaluation order of exercise of a wrongly typed cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1023)
- Evaluation order of exercise of a wrongly typed non-cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L908)
- Evaluation order of exercise of an inactive global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1005)
- Evaluation order of exercise of an inactive local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1107)
- Evaluation order of exercise of an unknown contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1191)
- Evaluation order of exercise of an wrongly typed local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1127)
- Evaluation order of exercise of cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1059)
- Evaluation order of exercise with argument exceeding max nesting: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1205)
- Evaluation order of exercise with output exceeding max nesting: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1232)
- Evaluation order of exercise-by-key of a cached global contract with visibility failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1453)
- Evaluation order of exercise-by-key of a non-cached global contract with visibility failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1334)
- Evaluation order of exercise_by_key of a cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1521)
- Evaluation order of exercise_by_key of a local contract with visibility failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1545)
- Evaluation order of exercise_by_key of a non-cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1308)
- Evaluation order of exercise_by_key of a wrongly typed cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1409)
- Evaluation order of exercise_by_key of an inactive global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1390)
- Evaluation order of exercise_by_key of an inactive local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1501)
- Evaluation order of exercise_by_key of an unknown contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1580)
- Evaluation order of exercise_by_key of cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1428)
- Evaluation order of exercise_by_key with argument exceeding max nesting: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1595)
- Evaluation order of exercise_by_key with contract ID in contract key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1666)
- Evaluation order of exercise_by_key with result exceeding max nesting: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1623)
- Evaluation order of exercise_interface of a cached local contract with failed authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1966)
- Evaluation order of exercise_interface of a non-cached global contract with failed authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1736)
- Evaluation order of exercise_interface of an inactive local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1902)
- Evaluation order of exercise_interface of an local contract not implementing the interface: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1921)
- Evaluation order of exercise_vy_key with empty contract key maintainers: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1652)
- Evaluation order of fetch of a cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2251)
- Evaluation order of fetch of a non-cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2043)
- Evaluation order of fetch of a non-cached global contract with inconsistent key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2065)
- Evaluation order of fetch of a wrongly typed cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2129)
- Evaluation order of fetch of a wrongly typed disclosed contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2271)
- Evaluation order of fetch of a wrongly typed non-cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2028)
- Evaluation order of fetch of an inactive global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2112)
- Evaluation order of fetch of an inactive local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2198)
- Evaluation order of fetch of an unknown contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2290)
- Evaluation order of fetch of an wrongly typed local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2216)
- Evaluation order of fetch of cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2163)
- Evaluation order of fetch-by-key of a cached global contract with visibility failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2457)
- Evaluation order of fetch-by-key of a non-cached global contract with visibility failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2374)
- Evaluation order of fetch_by_key of a cached global contract with authorization failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2440)
- Evaluation order of fetch_by_key of a local contract with authorization failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2516)
- Evaluation order of fetch_by_key of a non-cached global contract with authorization failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2352)
- Evaluation order of fetch_by_key of an inactive global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2421)
- Evaluation order of fetch_by_key of an inactive global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2498)
- Evaluation order of fetch_by_key of an unknown contract key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2545)
- Evaluation order of fetch_by_key with contract ID in contract key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2575)
- Evaluation order of fetch_by_key with contract key exceeding max nesting: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2589)
- Evaluation order of fetch_by_key with empty contract key maintainers: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2561)
- Evaluation order of fetch_interface of a cached global contract not implementing the interface.: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2712)
- Evaluation order of fetch_interface of a cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2840)
- Evaluation order of fetch_interface of a non-cached global contract that doesn't implement interface.: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2633)
- Evaluation order of fetch_interface of a non-cached global contract with failed authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2652)
- Evaluation order of fetch_interface of an inactive global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2695)
- Evaluation order of fetch_interface of an inactive local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2785)
- Evaluation order of fetch_interface of an local contract not implementing the interface: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2802)
- Evaluation order of fetch_interface of an unknown contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2858)
- Evaluation order of fetch_interface of cached global contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2750)
- Evaluation order of lookup of a cached global contract with visibility failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L3005)
- Evaluation order of lookup of a non-cached global contract with visibility failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2923)
- Evaluation order of lookup_by_key of a cached global contract with authorization failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2988)
- Evaluation order of lookup_by_key of a local contract with authorization failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L3079)
- Evaluation order of lookup_by_key of a local contract with failure authorization: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L3063)
- Evaluation order of lookup_by_key of a non-cached global contract with authorization failure: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2901)
- Evaluation order of lookup_by_key of an inactive global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2970)
- Evaluation order of lookup_by_key of an inactive local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L3046)
- Evaluation order of lookup_by_key of an unknown contract key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L3109)
- Evaluation order of lookup_by_key with contract ID in contract key: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L3139)
- Evaluation order of lookup_by_key with contract key exceeding max nesting: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L3153)
- Evaluation order of lookup_by_key with empty contract key maintainers: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L3125)
- Evaluation order of successful create: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L479)
- Evaluation order of successful create_interface: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L678)
- Evaluation order of successful exercise by interface of a non-cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1691)
- Evaluation order of successful exercise of a cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L981)
- Evaluation order of successful exercise of a local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1084)
- Evaluation order of successful exercise of a non-cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L882)
- Evaluation order of successful exercise_by_key of a cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1364)
- Evaluation order of successful exercise_by_key of a local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1477)
- Evaluation order of successful exercise_by_key of a non-cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1265)
- Evaluation order of successful exercise_interface of a cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1766)
- Evaluation order of successful exercise_interface of a local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1878)
- Evaluation order of successful fetch of a cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2095)
- Evaluation order of successful fetch of a local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2183)
- Evaluation order of successful fetch of a non-cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2006)
- Evaluation order of successful fetch_by_key of a cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2404)
- Evaluation order of successful fetch_by_key of a local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2482)
- Evaluation order of successful fetch_by_key of a non-cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2309)
- Evaluation order of successful fetch_interface of a cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2678)
- Evaluation order of successful fetch_interface of a local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2770)
- Evaluation order of successful fetch_interface of a non-cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2610)
- Evaluation order of successful lookup_by_key of a cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2953)
- Evaluation order of successful lookup_by_key of a local contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L3030)
- Evaluation order of successful lookup_by_key of a non-cached global contract: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2878)
- Exceptions, throw/catch.: [ExceptionTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/ExceptionTest.scala#L27)
- Rollback creates cannot be exercise: [EngineTest.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/EngineTest.scala#L2082)
- This checks that type checking in exercise_interface is done after checking activeness.: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1946)
- This checks that type checking is done after checking activeness.: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1833)
- This checks that type checking is done after checking activeness.: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L2822)
- contract key behaviour (non-unique mode): [ContractKeySpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ContractKeySpec.scala#L394)
- contract key behaviour (unique mode): [ContractKeySpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ContractKeySpec.scala#L404)
- contract keys must have a non-empty set of maintainers: [ContractKeySpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ContractKeySpec.scala#L213)
- contract keys should be evaluated after ensure clause: [ContractKeySpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ContractKeySpec.scala#L181)
- contract keys should be evaluated only when executing create: [ContractKeySpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ContractKeySpec.scala#L142)
- ensure builtin operators have the correct type: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L48)
- ensure expression forms have the correct type: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L108)
- exercise-by-interface command is rejected for a: [ApiCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ApiCommandPreprocessorSpec.scala#L171)
- exercise_interface with a contract instance that does not implement the interface fails.: [EvaluationOrderTest.scala](daml-lf/interpreter/src/test/scala/com/digitalasset/daml/lf/speedy/EvaluationOrderTest.scala#L1718)
- ill-formed create API command is rejected: [ApiCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ApiCommandPreprocessorSpec.scala#L159)
- ill-formed create replay command is rejected: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L109)
- ill-formed create-and-exercise API command is rejected: [ApiCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ApiCommandPreprocessorSpec.scala#L184)
- ill-formed exception definitions are rejected: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L1867)
- ill-formed exercise API command is rejected: [ApiCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ApiCommandPreprocessorSpec.scala#L164)
- ill-formed exercise replay command is rejected: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L114)
- ill-formed exercise-by-key API command is rejected: [ApiCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ApiCommandPreprocessorSpec.scala#L175)
- ill-formed exercise-by-key replay command is rejected: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L121)
- ill-formed expressions are rejected: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L460)
- ill-formed fetch command is rejected: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L168)
- ill-formed fetch-by-key command is rejected: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L171)
- ill-formed interfaces are rejected: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L1452)
- ill-formed kinds are rejected: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L20)
- ill-formed lookup command is rejected: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L176)
- ill-formed records are rejected: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L2009)
- ill-formed templates are rejected: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L1067)
- ill-formed type synonyms applications are rejected: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L1988)
- ill-formed type synonyms definitions are rejected: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L2055)
- ill-formed types are rejected: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L100)
- ill-formed variants are rejected: [TypingSpec.scala](daml-lf/validation/src/test/scala/com/digitalasset/daml/lf/validation/TypingSpec.scala#L2032)
- well formed create API command is accepted: [ApiCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ApiCommandPreprocessorSpec.scala#L115)
- well formed create replay command is accepted: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L80)
- well formed create-and-exercise API command is accepted: [ApiCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ApiCommandPreprocessorSpec.scala#L141)
- well formed exercise API command is accepted: [ApiCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ApiCommandPreprocessorSpec.scala#L120)
- well formed exercise replay command is accepted: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L85)
- well formed exercise-by-interface command is accepted: [ApiCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ApiCommandPreprocessorSpec.scala#L134)
- well formed exercise-by-key API command is accepted: [ApiCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ApiCommandPreprocessorSpec.scala#L127)
- well formed exercise-by-key command is accepted: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L93)
- well formed fetch replay command is accepted: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L145)
- well formed fetch-by-key replay command is accepted: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L150)
- well formed lookup replay command is accepted: [ReplayCommandPreprocessorSpec.scala](daml-lf/engine/src/test/scala/com/digitalasset/daml/lf/engine/ReplayCommandPreprocessorSpec.scala#L155)


