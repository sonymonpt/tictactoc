package org.example;

import org.example.model.Board;
import org.example.model.Player;

import java.util.List;
import java.util.Map;

public interface Tictactoc {

    /**
     * This method checks if there is a winning condition in the game.
     * It returns the name of the player who has won, or null if there is no winner yet.
     *
     * @return The name of the winning player or null if no winner.
     */
    char checkWin(Board board);

    void setupBoard(int i, List<Player> player1);

    Board getBoard();

    List<Player> getPlayers();
}
