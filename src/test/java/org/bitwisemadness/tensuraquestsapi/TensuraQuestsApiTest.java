package org.bitwisemadness.tensuraquestsapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * JUnit suite for the pure-logic side of the API. The CI {@code junit} check
 * asserts a non-zero test count so it cannot pass vacuously; replace this
 * placeholder with real tests as contracts land.
 */
class TensuraQuestsApiTest {

    @Test
    void modIdMatchesGradleProperty() {
        assertEquals("tensura_quests_api", TensuraQuestsApi.MOD_ID);
    }
}
