package com.games.mines;

public class Cell {

    private int row;
    private int column;
    private boolean isBomb;
    private int number;
    private boolean isExposed;

    Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.isBomb = false;
        this.isExposed = false;
        this.number = 0;
    }

    public boolean flip() {
        if (!isExposed) {
            isExposed = !isExposed;
        }
        return isBomb();
    }

    public void incrementNumber() {
        this.number += 1;
    }

    public void decrementNumber() {
        this.number -= 1;
    }

    public boolean isBlank() {
        return (this.isBomb == false && this.number == 0)? true : false;
    }

    public boolean isBomb() { return this.isBomb; }
    public int getRow() { return this.row; }
    public int getColumn() { return this.column; }
    public int getNumber() { return this.number; }
    public void setBomb() { this.isBomb = !isBomb; }
    public boolean isExposed() { return this.isExposed; }

    public void expose() { this.isExposed = !isExposed; }
}
