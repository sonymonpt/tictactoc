package org.example.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void testBoardInitialization() {
        Board board = new Board(3);

        // Check if the board is initialized correctly
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", board.getCells()[i][j].getValue());
            }
        }
    }
}
