package com.minessweeper;

public class MinesGrid extends Board{

    private int noOfMines;
    private char[][] board;
    private boolean[][] flags;
    private boolean[][] revealed;
    MinesGrid(int rows, int columns) {
        super(rows, columns);
    }

    protected void initBoard() {
        board = new char[this.getRows()][this.getColumns()];
        flags = new boolean[this.getRows()][this.getColumns()];
        revealed = new boolean[this.getRows()][this.getColumns()];

        for (int row = 0; row < this.getRows(); row++) {
            for (int column = 0; column < this.getColumns(); column++) {
                board[row][column] = 'E';
                flags[row][column] = false;
                revealed[row][column] = false;
            }
        }
    }

    private int countMines(int x, int y) {
        if (isOutOfBoundIndex(x, y)) return 0;
        int i = 0;
        for (int offsetX = -1; offsetX <= 1; offsetX++) {
            for (int offsetY = -1; offsetY <= 1; offsetY++) {
                if (isOutOfBoundIndex(offsetX+x, offsetY+y)) continue;
                if (board[offsetX+x][offsetY+y] == 'M') {
                    i++;
                }
            }
        }
        return i;
    }

    public void placeMines(int minesCount) {
        int i = 0;
        while (i < minesCount) {
            int x = getRandomNumber(0, this.getRows()-1);
            int y = getRandomNumber(0, this.getColumns()-1);
            if (board[x][y] == 'M') continue;
            board[x][y] = 'M';
            i++;
        }
    }

    public void reveal(int x, int y) throws Exception {
        if(isOutOfBoundIndex(x,y))return;

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            System.out.println("Booooom !!!");
            throw new Exception("You hit to mine");
        }

        int mines = countMines(x, y);
        if(mines > 0) {
            board[x][y] = (char) (mines + '0');
            return;
        }
        board[x][y] = 'B';

        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }

                int offsetX = i + x;
                int offsetY = j + y;
                if(!isOutOfBoundIndex(offsetX, offsetY) && board[offsetX][offsetY] == 'E') {
                    reveal(offsetX, offsetY);
                }
            }
        }
    }

    private boolean isOutOfBoundIndex(int x, int y) {
        return (x < 0 || y < 0 || x >= this.getRows() || y >= this.getColumns());
    }
    protected void print() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
