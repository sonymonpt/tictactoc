package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Cell {
    private int row;
    private int column;
    @Builder.Default
    private char value = ' ';
}
