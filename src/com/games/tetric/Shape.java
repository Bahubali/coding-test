package com.games.tetric;

import lombok.Getter;

@Getter
public class Shape {
    private int rows;
    private int columns;
    public int[][] grid;
    Shape(int rows, int columns) {
        this.grid = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }
}
