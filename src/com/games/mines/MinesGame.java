package com.games.mines;

public class MinesGame {

    private Board board;
    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    public MinesGame() {
        this.board = new Board(ROWS, COLUMNS);
        this.board.initBoard();
    }

    public void revealCell(int x, int y) {
        if (!board.inBounds(x, y)) return;

        Cell cell = board.getCell(x, y);
        if (board.getCell(x, y).isExposed()) return;

        if (board.getMinesCount(cell) > 0) return;
        cell.exposed();
        for (int[] coordinate: board.getCoordinates()) {
            int r = cell.getRow() + coordinate[0];
            int c = cell.getColumn() + coordinate[1];
            revealCell(r, c);
        }
    }

    public static void main(String[] args) {
        MinesGame game = new MinesGame();
        game.board.placeMines(5);
        game.board.exploreNumbers();
        game.revealCell(1, 3);
        game.board.print();
    }
}
