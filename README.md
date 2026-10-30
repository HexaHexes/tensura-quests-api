# Tensura Quests API

The contracts library of the Tensura RPG FTB Quests integration. It ships no
quest content and no gameplay of its own: installing it alone changes nothing
you can see in game.

## What it provides

Other mods compile against this library instead of against the implementation:

- **Task and reward type identifiers** - the canonical ids of every custom FTB
  Quests task and reward type the ecosystem registers, so pack content and
  tooling never hard-code namespace strings.
- **Outbound integration events** - plain NeoForge events that gameplay systems
  fire to request quest credit (for example, the future Faction Capitals
  system announcing a plot purchase). Producers depend on this library only,
  never on FTB Quests.
- **Shared version constants** - the api version that the implementation
  declares a minimum range against in its mod metadata.

The implementation mod, `tensura-quests`, consumes these contracts to register
custom task and reward types in FTB Quests. Quest presentation stays FTB
Quests' job; gameplay systems stay authoritative for their own state.

## Dependencies

| | Mod | Why |
|---|---|---|
| Required | Minecraft | - |
| Required | NeoForge | - |
| Optional | none | Every contract is self-contained; no gameplay mod is required to load this library |

## Using this library

Producers and modules consume it as a Maven dependency from the org's GitHub
Packages registry:

```groovy
repositories {
    maven {
        url = uri('https://maven.pkg.github.com/HexaHexes/tensura-quests-api')
        credentials {
            username = System.getenv('GITHUB_ACTOR')
            password = System.getenv('GITHUB_TOKEN') // read:packages
        }
    }
}

dependencies {
    compileOnly 'org.bitwisemadness.tensuraquestsapi:tensura_quests_api:<version>'
}
```

## Versioning

This library is semantic-versioned. Additive contracts bump the minor version;
anything that breaks a consumer bumps the major version and is announced before
the implementation adopts it.

## Credits

- Built on [NeoForge](https://neoforged.net/).

## License

GNU Lesser General Public License v2.1 - see [`LICENSE`](LICENSE).
Copyright (c) 2026 Bitwise Madness.

## AI disclosure

Parts of this project were written with the assistance of AI coding tools.
