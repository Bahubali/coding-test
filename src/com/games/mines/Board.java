package com.games.mines;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private int rows;
    private int columns;
    private Cell[][] cells;
    private List<Cell> bombs;
    private int numOfUnExposedCells;
    private int[][] surroundingCoordinates;

    Board(int rows, int columns) {
        this.cells = new Cell[rows][columns];
        this.numOfUnExposedCells = 0;
        this.rows = rows;
        this.columns = columns;
        this.bombs = new ArrayList<>();
    }

    public void initBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = new Cell(i, j);
                cells[i][j] = cell;
                numOfUnExposedCells++;
            }
        }
        this.surroundingCoordinates = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},{0, 1},
                {1, -1}, {1, 0},{1, 1}
        };
    }

    public void placeMines(int noOfMines) {
        Random random = new Random();
        while (noOfMines > 0) {
            int r = random.nextInt(rows);
            int c = random.nextInt(columns);
            Cell cell = cells[r][c];
            if (cell.isBlank()) {
                cell.setBomb();
                this.bombs.add(cell);
                cell.decrementNumber();
                noOfMines--;
            }
        }
    }

    public void exploreNumbers() {
        int[][] coordinates = getCoordinates();
        for(Cell cell: this.bombs) {
            for (int[] coordinate: coordinates) {
                int r = cell.getRow() + coordinate[0];
                int c = cell.getColumn() + coordinate[1];
                if (inBounds(r, c)) {
                    this.cells[r][c].incrementNumber();
                }
            }
        }
    }

    public boolean inBounds(int r, int c) {
        return (r >= 0 && c >= 0 && r < rows && c < columns);
    }

    public Cell getCell(int r, int c) {
        return this.cells[r][c];
    }

    public int getMinesCount(Cell cell) {
        int count = 0;
        int[][] coordinates = getCoordinates();
        for (int[] coordinate: coordinates) {
            int r = cell.getRow() + coordinate[0];
            int c = cell.getColumn() + coordinate[1];
            if (inBounds(r, c)) {
               Cell neighbour = this.cells[r][c];
               if (neighbour.isBomb()) count++;
            }
        }
        return count;
    }

    public int[][] getCoordinates() {
        return this.surroundingCoordinates;
    }
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = this.cells[i][j];
                if (cell.isExposed()) {
                    //System.out.println(cell.getNumber());
                    String cChar = (cell.isBomb()) ? "*" : (cell.getNumber() > 0) ? String.valueOf(cell.getNumber()) : "B";
                    System.out.print(cChar + "  ");
                } else {
                    System.out.print("E  ");
                }
            }
            System.out.println();
        }
    }
}
