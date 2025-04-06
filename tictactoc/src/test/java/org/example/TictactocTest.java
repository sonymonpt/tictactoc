package org.example;

import org.example.model.Board;
import org.example.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class TictactocTest {

    static Tictactoc tictactoc;

    @BeforeEach
    public void setUp() {
        tictactoc = new TictactocImpl();
    }

    @Test
    public void testSetupBoard() {
        Player player1 = new Player("Sony", "X");
        Player player2 = new Player("Ravi", "O");

        tictactoc.setupBoard(3, List.of(player1, player2));
        Assertions.assertEquals(3, tictactoc.getBoard().getSize());
        Assertions.assertEquals(' ', tictactoc.getBoard().getCells()[0][0].getValue());
        Assertions.assertEquals("Sony", tictactoc.getPlayers().getFirst().name());
    }

    @ParameterizedTest
    @CsvSource({
            "XXX,0X0,XOX,X", "OXO,XXX,X O,X", "OXO,X X,XXX ,X",
            "0X0,0X0,XXX,X", "X O,XOO,XXO,X", "XOX,0XX,0XX,X",
            "XOO,OXX,O X,X", "OOX,XXO,XOO,X"
    })
    public void testCheckWin(String row1, String row2, String row3, String result) throws NoSuchFieldException, IllegalAccessException {
        Board board = createBoard(row1, row2, row3);
        tictactoc.setupBoard(3, List.of(new Player("Sony", "X"), new Player("Ravi", "O")));
        // Simulate moves above 5
        tictactoc.setMoves(8);

        Assertions.assertEquals(result.charAt(0), tictactoc.checkWin(board));
    }

    @ParameterizedTest
    @CsvSource({
            "XXXO,0X0O,XOOX,00XX,' '","XXXO,0X0O,XOXX,00XX,X",
            "XXXX,0X0O,XOOX,00XX,'X"

    })
    public void testFourSizeBoardCheckWin(String row1, String row2, String row3,String row4, String result) throws NoSuchFieldException, IllegalAccessException {

        tictactoc.setupBoard(4, List.of(new Player("Sony", "X"), new Player("Ravi", "O")));
        Board board = createfourBoard(row1, row2, row3,row4);
        // Simulate moves above 5
        tictactoc.setMoves(8);

        Assertions.assertEquals(result.charAt(0), tictactoc.checkWin(board));
    }

    @Test
    public void testBoardIsNull() {
        Assertions.assertEquals(' ', tictactoc.checkWin(null));
    }

    @ParameterizedTest
    @CsvSource({"XOX,OOX,OXO,' '", "XOX,OOO,OXO,' '"})
    public void testMinMove(String row1, String row2, String row3, String result) {
        Board board = createBoard(row1, row2, row3);
        // Simulate moves below 5
        tictactoc.setMoves(4);
        Assertions.assertEquals(result.charAt(0), tictactoc.checkWin(board));
    }

    @ParameterizedTest
    @CsvSource({"XOX,OOX,OXO,D", "XOX,OOO,OXO,O"})
    public void testDrawMove(String row1, String row2, String row3, String result) {
        Board board = createBoard(row1, row2, row3);
        // Simulate moves to max
        tictactoc.setMoves(9);
        Assertions.assertEquals(result.charAt(0), tictactoc.checkWin(board));
    }

    private Board createBoard(String row1, String row2, String row3) {
        Board board = new Board(3);

        board.getCells()[0][0].setValue(row1.charAt(0));
        board.getCells()[0][1].setValue(row1.charAt(1));
        board.getCells()[0][2].setValue(row1.charAt(2));
        board.getCells()[1][0].setValue(row2.charAt(0));
        board.getCells()[1][1].setValue(row2.charAt(1));
        board.getCells()[1][2].setValue(row2.charAt(2));
        board.getCells()[2][0].setValue(row3.charAt(0));
        board.getCells()[2][1].setValue(row3.charAt(1));
        board.getCells()[2][2].setValue(row3.charAt(2));
        return board;
    }

    private Board createfourBoard(String row1, String row2, String row3,String row4) {
        Board board = new Board(4);

        board.getCells()[0][0].setValue(row1.charAt(0));
        board.getCells()[0][1].setValue(row1.charAt(1));
        board.getCells()[0][2].setValue(row1.charAt(2));
        board.getCells()[0][3].setValue(row1.charAt(3));

        board.getCells()[1][0].setValue(row2.charAt(0));
        board.getCells()[1][1].setValue(row2.charAt(1));
        board.getCells()[1][2].setValue(row2.charAt(2));
        board.getCells()[1][3].setValue(row2.charAt(3));

        board.getCells()[2][0].setValue(row3.charAt(0));
        board.getCells()[2][1].setValue(row3.charAt(1));
        board.getCells()[2][2].setValue(row3.charAt(2));
        board.getCells()[2][3].setValue(row3.charAt(3));

        board.getCells()[3][0].setValue(row4.charAt(0));
        board.getCells()[3][1].setValue(row4.charAt(1));
        board.getCells()[3][2].setValue(row4.charAt(2));
        board.getCells()[3][3].setValue(row4.charAt(3));

        return board;
    }
}