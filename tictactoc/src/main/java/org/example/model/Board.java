package org.example.model;

import lombok.Getter;

@Getter
public class Board {
    private Cell[][] cells;
    private int size;

    public Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = Cell.builder().row(i).column(j).value(' ').build();
            }
        }
    }
}
