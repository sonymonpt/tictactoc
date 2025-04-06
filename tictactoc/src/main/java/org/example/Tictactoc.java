package org.example;

import org.example.model.Board;
import org.example.model.Player;

import java.util.List;

public interface Tictactoc {


    /**
     * This method sets up the game board and initializes the players.
     *
     * @param size    The size of the board.
     * @param players The list of players.
     */
    void setupBoard(int size, List<Player> players);

    /**
     * This method returns the current state of the game board.
     *
     * @return The current game board.
     */
    Board getBoard();

    /**
     * This method returns the list of players in the game.
     *
     * @return The list of players.
     */
    List<Player> getPlayers();

    /**
     * This method set the number of moves made in the game.
     */
    void setMoves(int moves); // Added setMoves method

    /**
     * This method checks if there is a winning condition in the game.
     * It returns the name of the player who has won, or null if there is no winner yet.
     *
     * @return The name of the winning player or null if no winner.
     */
    char checkWin(Board board);
}
