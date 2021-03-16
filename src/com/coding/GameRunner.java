package com.coding;

public class GameRunner {

    public static void main(String[] args) throws Exception{
        Game2048 board = new Game2048(4, 4);
        board.addEntry(2, Position.builder().row(0).column(2).build());
        board.addEntry(2, Position.builder().row(0).column(1).build());
        board.addEntry(2, Position.builder().row(0).column(0).build());
        board.print();
        board.makeMove(Direction.RIGHT);
        board.addEntry(2, Position.builder().row(0).column(1).build());
        board.makeMove(Direction.LEFT);
        board.makeMove(Direction.RIGHT);
        board.addEntry(4, Position.builder().row(2).column(3).build());
        board.makeMove(Direction.DOWN);
        board.addEntry(4, Position.builder().row(3).column(0).build());
        board.print();
        board.makeMove(Direction.RIGHT);
        board.makeMove(Direction.DOWN);
        board.addEntry(4, Position.builder().row(3).column(1).build());
        board.addEntry(4, Position.builder().row(3).column(2).build());
        board.makeMove(Direction.RIGHT);
        board.addEntry(8, Position.builder().row(0).column(2).build());
        board.makeMove(Direction.DOWN);
        board.makeMove(Direction.RIGHT);
    }
}
