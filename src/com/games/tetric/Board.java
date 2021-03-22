package com.games.tetric;

import lombok.Getter;

@Getter
public abstract class Board {

    private int rows;
    private int columns;

    Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    protected abstract void initBoard();
    protected abstract void print();
    protected abstract void clear();
    protected abstract void move(Coordinate coordinate, IShape shape);
}
