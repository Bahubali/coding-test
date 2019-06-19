package com.games.chess;


/**
 * Created by bahubali.n on 16/06/19.
 */
public abstract class Board {

    public int rows;

    public int columns;

    Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    protected abstract void initializeBoard();
}
