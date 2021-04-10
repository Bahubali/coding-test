package com.games.othello;

import java.nio.file.ClosedWatchServiceException;

public class Board {
    private int blackCount = 0;
    private int whiteCount = 0;
    private Piece[][] board;
    private int rows;
    private int columns;
    private int[][] directions;

    Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new Piece[rows][columns];
        initializeBoard();
    }

    private void initializeBoard() {
        int mid = (this.board.length - 1)/2;
        this.board[mid][mid] = new Piece(Color.WHITE);
        this.board[mid][mid+1] = new Piece(Color.WHITE);
        this.board[mid+1][mid] = new Piece(Color.BLACK);
        this.board[mid+1][mid+1] = new Piece(Color.BLACK);
        this.directions = new int[][]{{0, -1},{0, 1}, {-1, 0}, {1, 0}};
    }

    public boolean placePiece(int r, int c, Color color) {
        if (!isValid(r, c)) return false;
        if (this.board[r][c] != null) return false;
        this.board[r][c] = new Piece(color);
        this.checkFlipPossible(color);
        return true;
    }

    private void checkFlipPossible(Color color) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                Piece piece = this.board[i][j];
                if (piece == null || color == piece.getColor()) continue;

                 Cell left = new Cell(i, j-1);
                 Cell right = new Cell(i, j+1);
                 if (isValid(left.x, left.y) && isValid(right.x, right.y)) {
                     if (this.board[left.x][left.y] != null
                             && this.board[right.x][right.y] != null
                             && this.board[left.x][left.y].getColor() == color
                             && this.board[right.x][right.y].getColor() == color
                     ) {
                         this.board[i][j].flip();
                     }
                 }
                Cell top = new Cell(i-1, j);
                Cell bottom = new Cell(i+1, j);
                if (isValid(top.x, top.y) && isValid(bottom.x, bottom.y)) {
                    if (this.board[top.x][top.y] != null
                            && this.board[bottom.x][bottom.y] != null
                            && this.board[top.x][top.y].getColor() == color
                            && this.board[bottom.x][bottom.y].getColor() == color
                    ) {
                        this.board[i][j].flip();
                    }
                }

            }
        }
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 || y >= 0 || x < this.rows || y < this.columns);
    }

    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.board[i][j] == null) System.out.print("0 ");
                else {
                    String color = (this.board[i][j].getColor() == Color.WHITE) ? "W" : "B";
                    System.out.print(color + " ");
                }
            }
            System.out.println();
        }
    }

    public static class Cell {
        public int x;
        public int y;
        Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
