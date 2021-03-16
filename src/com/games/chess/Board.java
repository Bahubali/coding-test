package com.games.chess;


/**
 * Created by bahubali.n on 16/06/19.
 */
public abstract class Board {

    protected int rows;

    protected int columns;

    Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }
    protected abstract void initializeBoard();
}
