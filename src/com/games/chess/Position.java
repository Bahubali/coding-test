package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Position {
    private int row, column;

    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public String toString() {
        return row + ","+column;
    }

    public String getKey() { return row + "" + column; }
}
