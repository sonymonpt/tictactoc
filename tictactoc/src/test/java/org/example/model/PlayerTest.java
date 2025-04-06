package org.example.model;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    // Test cases for Player class
    // 1. Test if the Player class can be instantiated
    // 2. Test if the name and symbol properties are set correctly

    // Example test case
    @Test
    public void testPlayerInstantiation() {
        Player player = new Player("Sony","X");
        assert player.name().equals("Sony");
        assert player.symbol().equals("X");
    }
}
