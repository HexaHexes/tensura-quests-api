package org.bitwisemadness.tensuraquestsapi.gametest;

import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;
import org.bitwisemadness.tensuraquestsapi.TensuraQuestsApi;

/**
 * Smoke test: proves the API mod loads and the GameTest harness runs.
 *
 * <p>Keep the {@code expectedTests} count in {@code build.gradle} in sync with
 * the number of {@code @GameTest} methods here, or the harness fails the
 * run.</p>
 */
@GameTestHolder(TensuraQuestsApi.MOD_ID)
@PrefixGameTestTemplate(false)
public final class TensuraQuestsApiGameTests {

    private TensuraQuestsApiGameTests() {
    }

    /** The API mod is loaded and the empty structure template resolves. */
    @GameTest(template = "empty")
    public static void api_mod_loads(GameTestHelper helper) {
        helper.succeed();
    }
}
