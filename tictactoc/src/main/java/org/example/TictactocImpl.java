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

        // Check rows and columns
        for (int i = 0; i < board.getSize(); i++) {
            if (isWinningLine(board, i, 0, 0, 1)) {
                return board.getCells()[i][0].getValue();
            }
            if (isWinningLine(board, 0, i, 1, 0)) {
                return board.getCells()[0][i].getValue();
            }

        }

        // Check main diagonal
        if (isWinningLine(board, 0, 0, 1, 1)) {
            return board.getCells()[0][0].getValue();
        }

        // Check anti-diagonal
        if (isWinningLine(board, 0, board.getSize() - 1, 1, -1)) {
            return board.getCells()[0][board.getSize() - 1].getValue();
        }

        return moves == board.getSize() * board.getSize() ? 'D' : ' ';
    }

    private boolean isWinningLine(Board board, int row, int col, int rowIncrement, int colIncrement) {
        char first = board.getCells()[row][col].getValue();
        if (first == ' ') {
            return false;
        }
        return java.util.stream.IntStream.range(1, board.getSize())
                .allMatch(i -> board.getCells()[row + i * rowIncrement][col + i * colIncrement].getValue() == first);
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