package org.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    public void testCellInstantiation() {
        // Test cases for Cell class
        Cell cell = Cell.builder().row(1).column(2).build();

        assert cell.getRow() == 1;
        assert cell.getColumn() == 2;
        Assertions.assertEquals(cell.getValue(),' ');
    }

    @Test
    public void testCellWithValue() {
        // Test cases for Cell class
        Cell cell = Cell.builder().row(1).column(2).build();
        cell.setValue('X');
        assert cell.getRow() == 1;
        assert cell.getColumn() == 2;
        Assertions.assertEquals(cell.getValue(),'X');
    }
}
