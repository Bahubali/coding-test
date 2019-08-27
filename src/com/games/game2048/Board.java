package com.games.game2048;

public abstract class Board {

    private final int rows;
    private final int columns;

    protected Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    protected abstract void initializeBoard();
    protected int getRows() { return rows; }
    protected int getColumns() { return columns; }
}
