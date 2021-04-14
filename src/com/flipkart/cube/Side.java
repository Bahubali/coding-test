package com.flipkart.cube;

public class Side {
    private int rows;
    private int columns;
    private int value;
    private int[][] grid;

    Side(int r, int c, int val) {
        this.rows = r;
        this.columns = c;
        this.value = val;
        this.grid = new int[r][c];
        this.init();
    }

    private void init() {
        for (int row = 0; row< this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                this.grid[row][column] = this.value;
            }
        }
    }

    public void rotateClockWise() {
        int n = this.columns;
        for (int row = 0; row < n/2; row++) {
            for (int column = 0; column < n-1-row; column--) {
                int temp = this.grid[row][column];
                this.grid[row][column] = this.grid[n-1-column][row];
                this.grid[n-1-column][row] = this.grid[n-1-row][n-1-column];
                this.grid[n-1-row][n-1-column] = this.grid[column][n-1-row];
                this.grid[column][n-1-row] = temp;
            }
        }
    }

    public void rotateAntiClockWise() {
        int n = this.columns;
        for (int row = 0; row < n/2; row++) {
            for (int column = 0; column < n-1-row; column--) {
                int temp = this.grid[row][column];

                this.grid[row][column] = this.grid[n-1-column][row];
                this.grid[n-1-column][row] = this.grid[n-1-row][n-1-column];
                this.grid[n-1-row][n-1-column] = this.grid[column][n-1-row];
                this.grid[column][n-1-row] = temp;
            }
        }
    }

    public int getVal(int row, int column) {
        return this.grid[row][column];
    }

    public void setVal(int row, int column, int val) {
        this.grid[row][column] = val;
    }

    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(this.grid[i][j]);
            }
        }
    }
    public int getRows() { return this.rows; }
    public int getColumns() { return this.columns; }
}
