package com.games.tetric;

import java.sql.Array;
import java.util.Arrays;

public class TetrixBoard extends Board{

    private int[][] tetrix;
    TetrixBoard(int rows, int columns) {
        super(rows, columns);
        this.tetrix = new int[rows][columns];
        this.initBoard();
    }

    @Override
    protected void initBoard() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                this.tetrix[i][j] = 0;
            }
        }
//        this.tetrix[0][3] = 1;
//        this.tetrix[0][2] = 1;
//        this.tetrix[2][0] = 1;
//        this.tetrix[3][1] = 1;
//        this.tetrix[3][2] = 1;
    }

    @Override
    protected void print() {
        for (int row = 0; row < this.getRows(); row++) {
            for (int column = 0; column < this.getColumns(); column++) {
                System.out.print(this.tetrix[row][column]+"  ");
            }
            System.out.println();
        }
    }

    @Override
    protected void clear() {
        int row = this.getRows() - 1;
        for (int i = row; i > 0; i--) {
            boolean isRowFilled = true;
            for (int j = 0; j < this.getColumns(); j++) {
                if(this.tetrix[i][j] == 0) {
                    isRowFilled = false;
                    break;
                }
            }
            if (isRowFilled) {
                for (int j = 0; j < this.getColumns(); j++) {
                    for (int k = row; k > 0; k--) {
                        this.tetrix[k][j] = this.tetrix[k - 1][j];
                        this.tetrix[k - 1][j] = 0;
                    }
                }
            }
        }
    }

    @Override
    protected void move(Coordinate coordinate, IShape shape) {
        int i = coordinate.getX();
        int j = coordinate.getY();
        int prev = i - 1;
        while (i <= (this.getRows() - shape.getRows())) {
            int[][] grid = copyGrid(i, coordinate.getY(), i+shape.getRows(), j+shape.getColumns());
            if (canMove(grid, shape.getShape())) {
                if (prev >= 0)
                    clearShape(prev, coordinate.getY(), prev+shape.getRows(), j+shape.getColumns(), shape.getShape());
                copyShape(i, coordinate.getY(), i+shape.getRows(), j+shape.getColumns(), shape.getShape());
            }
            prev = i;
            i++;
        }
        //clear();
    }


    private boolean canMove(int[][] grid, int[][] shape) {
        boolean canMove = true;
        for (int i = grid.length - 1; i > 0; i--) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && shape[i][j] == 1) {
                    canMove = false;
                }
            }
            if (canMove) break;
        }
        return canMove;
    }

    private int[][] copyGrid(int i, int j, int rows, int columns) {
        int[][] grid = new int[rows-i][columns-j];
        int m = 0;
        for (; i< rows; i++) {
            int n = 0;
            int k = j;
            for (; k < columns; k++) {
                grid[m][n++] = this.tetrix[i][k];
            }
            m++;
        }
        return grid;
    }

    private void copyShape(int i, int j, int rows, int columns, int[][] shape) {
        int m = 0;
        for (; i< rows; i++) {
            int n = 0;
            int k = j;
            for (; k < columns; k++) {
                //grid[m][n++] = this.tetrix[i][k];
                if (this.tetrix[i][k] == 0)
                    this.tetrix[i][k] = shape[m][n++];
            }
            m++;
        }
    }

    private void clearShape(int i, int j, int rows, int columns, int[][] shape) {
        int m = 0;
        for (; i< rows; i++) {
            int n = 0;
            int k = j;
            for (; k < columns; k++) {
                //grid[m][n++] = this.tetrix[i][k];
                if (shape[m][n++] == 1)
                    this.tetrix[i][k] = 0;
            }
            m++;
        }
    }

}
