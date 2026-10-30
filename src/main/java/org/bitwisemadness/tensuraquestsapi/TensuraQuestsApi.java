package org.bitwisemadness.tensuraquestsapi;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

/**
 * Tensura Quests API entry point.
 *
 * <p>This mod is the contracts library of the Tensura RPG FTB Quests
 * integration ecosystem. It publishes task and reward type identifiers, the
 * outbound integration events that gameplay producers fire for quest credit,
 * and shared version constants. It ships no quest content and no gameplay of
 * its own: installing it alone changes nothing visible in game.</p>
 *
 * <p>Consumers: {@code tensura-quests} (the implementation) compiles against
 * every contract here, and gameplay systems that want to drive quest progress
 * (the future Faction Capitals system, pack tooling) compile against this
 * library only, never against FTB Quests or the implementation.</p>
 */
@Mod(TensuraQuestsApi.MOD_ID)
public final class TensuraQuestsApi {

    public static final String MOD_ID = "tensura_quests_api";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TensuraQuestsApi(IEventBus modBus) {
        LOGGER.info("Tensura Quests API initialized");
    }
}
