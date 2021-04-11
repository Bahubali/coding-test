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
        if (!this.board.inBounds(x, y)) return;

        Cell cell = this.board.getCell(x, y);
        if (this.board.getCell(x, y).isExposed()) return;

        if (this.board.getMinesCount(cell) > 0) {
            cell.expose();
            return;
        }
        cell.expose();
        for (int[] coordinate: this.board.getCoordinates()) {
            int r = cell.getRow() + coordinate[0];
            int c = cell.getColumn() + coordinate[1];
            revealCell(r, c);
        }
    }

    public static void main(String[] args) {
        MinesGame game = new MinesGame();
        game.board.placeMines(5);
        game.board.exploreNumbers();
        //game.board.print();
        game.revealCell(1, 3);
        game.revealCell(2, 4);
        game.board.print();
    }
}
