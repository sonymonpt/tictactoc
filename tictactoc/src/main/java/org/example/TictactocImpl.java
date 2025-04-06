package org.example;

import org.example.model.Board;
import org.example.model.Player;

import java.util.List;

public class TictactocImpl implements Tictactoc {

    private Board board;
    private List<Player> players;

    /**
     * @return
     */
    @Override
    public char checkWin(Board board) {
        // Check rows
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCells()[i][0].getValue() == board.getCells()[i][1].getValue() &&
                    board.getCells()[i][1].getValue() == board.getCells()[i][2].getValue() &&
                    board.getCells()[i][0].getValue() != ' ') {
                return  board.getCells()[i][0].getValue();
            }
        }
        // Check columns
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCells()[0][i].getValue() == board.getCells()[1][i].getValue() &&
                    board.getCells()[1][i].getValue() == board.getCells()[2][i].getValue() &&
                    board.getCells()[0][i].getValue() != ' ') {
                return  board.getCells()[0][i].getValue();
            }
        }
        // Check diagonals
        if (board.getCells()[0][0].getValue() == board.getCells()[1][1].getValue() &&
                board.getCells()[1][1].getValue() == board.getCells()[2][2].getValue() &&
                board.getCells()[0][0].getValue() != ' ') {
            return  board.getCells()[0][0].getValue();
        }
        // Check anti-diagonal
        if (board.getCells()[0][2].getValue() == board.getCells()[1][1].getValue() &&
                board.getCells()[1][1].getValue() == board.getCells()[2][0].getValue() &&
                board.getCells()[0][2].getValue() != ' ') {
            return  board.getCells()[0][2].getValue();
        }
        return ' ';
    }

    /**
     * @param size
     * @param players
     */
    @Override
    public void setupBoard(int size, List<Player> players) {
        this.board = new Board(size);
        this.players= players;
    }

    /**
     * @return
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     * @return
     */
    @Override
    public List<Player> getPlayers() {
        return players;
    }

}
