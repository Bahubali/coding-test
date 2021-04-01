package com.minessweeper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Board {

    private int rows;
    private int columns;

    Board(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
    }

    protected abstract void initBoard();
    protected abstract void print();
}
