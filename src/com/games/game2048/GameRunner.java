package com.games.game2048;

public class GameRunner {
    public static void main(String[] args) {
        Board2048 board = new Board2048(4);
        try {
            board.swipe(Direction.LEFT);
            board.addEntry(2, new Position(0, 1));
            board.swipe(Direction.RIGHT);
            board.addEntry(4, new Position(0, 0));
            board.swipe(Direction.LEFT);
            board.swipe(Direction.DOWN);
            board.swipe(Direction.RIGHT);
            board.addEntry(8, new Position(2, 3));
            board.swipe(Direction.UP);
            board.addEntry(8, new Position(0, 3));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
