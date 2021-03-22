package com.games.tetric;

public abstract class AbstractShape implements IShape {

    private final int rows;
    private final int columns;
    AbstractShape(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public abstract int[][] getShape();

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public int getColumns() {
        return this.columns;
    }
}
