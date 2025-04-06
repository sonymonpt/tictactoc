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
    // Test cases for the Tic Tac Toe game
    // 1. Test case for a winning move
    // 2. Test case for a draw
    // 3. Test case for an empty board

    static Tictactoc tictactoc;

    @BeforeEach
    public void setUp() {
        // Initialize the Tic Tac Toe game
        tictactoc = new TictactocImpl();
    }

    @Test
    public void testSetupBoard(){
        Player player1 = new Player("Sony","X");
        Player player2 = new Player("Ravi","O");

        tictactoc.setupBoard(3, List.of(player1,player2));
        // Check if the board is set up correctly
        Assertions.assertEquals(tictactoc.getBoard().getSize(),3);
        Assertions.assertEquals(tictactoc.getBoard().getCells()[0][0].getValue()," ");
        Assertions.assertEquals(tictactoc.getPlayers().get(0).name(),"Sony");
    }


    @ParameterizedTest
    @CsvSource(
            {
                  "XXX,0X0,XOX,X","OXO,XXX,XO' ',X","OXO,X' 'X,XXX ,X",
                  "0X0,0X0,XXX,X","X O,XOO,XXO,X","XOX,0XX,0XX,X",
                    "XOO,OXX,O X,X","OOX,XXO,XOO,X"
            }
    )
    public void testWinningMove(String row1, String row2, String row3,String result) {

        // Check if "X" wins
        Assertions.assertEquals(tictactoc.checkWin(createBoard(row1, row2, row3)),result.charAt(0));
    }

    private Board createBoard(String row1, String row2, String row3) {
        // Create a winning board configuration
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
}
