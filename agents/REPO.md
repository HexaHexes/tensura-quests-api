# Repo rules - Tensura Quests API

Repo-specific rules and notes. The org-wide `AGENTS.md` beside this file is
maintained in [`neoforge-mod-template`](https://github.com/HexaHexes/neoforge-mod-template)
and pulled in verbatim - **never hand-edit it.** Everything in this file is this
repo's own and is edited freely; keep it aligned with the org rules rather than
restating them.

**Repo:** `HexaHexes/tensura-quests-api` - **Mod ID:** `tensura_quests_api` - **Branch:** `main`
**Platform:** Minecraft 1.21.1 / NeoForge 21.1.259 / JDK 21 - **Jar:** `build/libs/tensura_quests_api-<version>.jar`

The contracts library of the Tensura RPG FTB Quests integration ecosystem. It
publishes custom task/reward type identifiers, the outbound integration events
gameplay producers fire for quest credit, and shared version constants. It
ships no quest content and no gameplay: it must stay installable on its own
with no hard dependencies beyond Minecraft and NeoForge.

**Dependencies**
- Required: Minecraft, NeoForge.
- Optional: none. Producers (the future Faction Capitals system, pack tooling)
  compile against this library only; the implementation (`tensura-quests`)
  compiles against every contract here.

**Test:** `./gradlew runGameTestServer` - `TensuraQuestsApiGameTests` (1 test).
`expectedTests = 1` in `build.gradle` must match the `@GameTest` count.

**Remote:** `github.com/HexaHexes/tensura-quests-api` (private, default branch
`main`).

---

## Gotchas (do not regress them)

- This library must never depend on FTB Quests, Sympathetic Jobs, Lightman's
  Currency, the infinite-dungeon suite, or `tensura-quests`. Dependencies point
  inward only: the implementation depends on the API, never the reverse.
- A contract here must not leak a gameplay class. Events carry ids (player
  UUIDs, resource locations, numbers), never live entities or menu objects, so
  a producer never needs a transitive dependency to fire them.
- Public API stability is the whole product. Prefer additive changes; announce
  breaking ones with a major bump before the implementation adopts them.
- The `empty` GameTest structure lives at
  `src/gametest/resources/data/tensura_quests_api/structure/empty.nbt`; moving
  it or renaming the mod id breaks the smoke test.

## Naming - this repo

- Repo and folder: `tensura-quests-api`; `mod_id`: `tensura_quests_api`;
  Java base package `org.bitwisemadness.tensuraquestsapi`, with the Maven
  `group` in `build.gradle` matching.

## CI & release model - this repo

- `ci.yml` runs the template's three checks (junit, gametest, version-bump).
- `release.yml` cuts the GitHub release for `v<mod_version>` on a push to
  `main` (pre-releases only when the repo variable `ALPHA_RELEASES` is true).
- This is the ecosystem's published library: `publish.yml` uploads the artifact
  to the org's GitHub Packages registry when that release is published, under
  the version in `gradle.properties`. `tensura-quests` consumes it from that
  registry with `api_version` in its `gradle.properties` pinned to a published
  version.
