package org.example;

import org.example.model.Board;
import org.example.model.Player;

import java.util.List;

import static java.util.Objects.isNull;

public class TictactocImpl implements Tictactoc {

    private Board board;
    private List<Player> players;
    private int moves = 0;

    @Override
    public char checkWin(Board board) {
        if (isNull(board)) {
            return ' ';
        }

        if (moves < board.getSize() * 2 - 1) {
            return ' ';
        }

        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCells()[i][0].getValue() == board.getCells()[i][1].getValue() &&
                    board.getCells()[i][1].getValue() == board.getCells()[i][2].getValue() &&
                    board.getCells()[i][0].getValue() != ' ') {
                return board.getCells()[i][0].getValue();
            }
        }

        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCells()[0][i].getValue() == board.getCells()[1][i].getValue() &&
                    board.getCells()[1][i].getValue() == board.getCells()[2][i].getValue() &&
                    board.getCells()[0][i].getValue() != ' ') {
                return board.getCells()[0][i].getValue();
            }
        }

        if (board.getCells()[0][0].getValue() == board.getCells()[1][1].getValue() &&
                board.getCells()[1][1].getValue() == board.getCells()[2][2].getValue() &&
                board.getCells()[0][0].getValue() != ' ') {
            return board.getCells()[0][0].getValue();
        }

        if (board.getCells()[0][2].getValue() == board.getCells()[1][1].getValue() &&
                board.getCells()[1][1].getValue() == board.getCells()[2][0].getValue() &&
                board.getCells()[0][2].getValue() != ' ') {
            return board.getCells()[0][2].getValue();
        }

        return moves == board.getSize() * board.getSize() ? 'D' : ' ';
    }

    @Override
    public void setupBoard(int size, List<Player> players) {
        this.board = new Board(size);
        this.players = players;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void setMoves(int moves) {
        this.moves = moves;
    }
}