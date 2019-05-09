package com.game2048;

/**
 * Created by bahubali.n on 15/01/19.
 */
public class Grid {

    private static final int GRID_SIZE = 4;
    public Tile[][] tiles = new Tile[GRID_SIZE][GRID_SIZE];

    public Grid() {
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = new Tile(0);
            }
        }
    }

    public void addTile(int row, int column, Tile tile) {
        if (tiles[row][column].getValue() == 0) {
            tiles[row][column].setValue(tile.getValue());
        }
    }

    public void move(Direction direction) {

        switch (direction) {
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
            case DOWN:
                moveDown();
                break;
            case UP:
                moveUp();
                break;
        }
    }

    public void moveRight() {
        for (int row = 0; row < tiles[0].length; row++) {
            boolean isMergeHappened = false;
            swipeToEdge(row, -1, Direction.RIGHT);
            for (int column = tiles.length - 1; column > 0; column--) {
                if (tiles[row][column].equal(tiles[row][column-1])) {
                    tiles[row][column].merge(tiles[row][column-1]);
                    tiles[row][column-1].clear();
                    isMergeHappened = true;
                }
            }
            if (isMergeHappened)
                swipeToEdge(row, -1, Direction.RIGHT); // -1 for column will represent swipe horizontal with direction to arrange elements
        }
    }

    public void moveLeft() {
        for (int row = 0; row < tiles[0].length; row++) {
            boolean isMergeHappened = false;
            swipeToEdge(row, -1, Direction.RIGHT);
            for (int column = 0; column < tiles.length - 1; column++) {
                if (tiles[row][column].equal(tiles[row][column+1])) {
                    tiles[row][column].merge(tiles[row][column+1]);
                    tiles[row][column+1].clear();
                    isMergeHappened = true;
                }
            }
            if (isMergeHappened)
                swipeToEdge(row, -1, Direction.LEFT); // -1 for column will represent swipe horizontal with direction to arrange elements
        }
    }

    public void moveDown() {
        for (int column = 0; column < tiles[0].length; column++) {
            boolean isMergeHappened = false;
            swipeToEdge(-1, column, Direction.DOWN);
            for (int row = tiles.length - 1; row > 0; row--) {
                if (tiles[row][column].equal(tiles[row-1][column])) {
                    tiles[row][column].merge(tiles[row-1][column]);
                    tiles[row-1][column].clear();
                    isMergeHappened = true;
                }
            }
            if (isMergeHappened)
                swipeToEdge(-1, column, Direction.DOWN); // -1 for column will represent swipe horizontal with direction to arrange elements
        }
    }

    public void moveUp() {
        for (int column = 0; column < tiles[0].length; column++) {
            boolean isMergeHappened = false;
            swipeToEdge(-1, column, Direction.UP);
            for (int row = 0; row < tiles[0].length - 1; row++) {
                if (tiles[row][column].equal(tiles[row+1][column])) {
                    tiles[row][column].merge(tiles[row+1][column]);
                    tiles[row+1][column].clear();
                    isMergeHappened = true;
                }
            }
            if (isMergeHappened)
                swipeToEdge(-1, column, Direction.UP); // -1 for column will represent swipe horizontal with direction to arrange elements
        }
    }


    public void swipeToEdge(int row, int column, Direction direction) {

        /**
         * Horizontal swipe and re-arrange 0's ASC/DESC order based on direction RIGHT/LEFT
         */
        if (column < 0) {
            if (direction == Direction.RIGHT) {
                int right = tiles.length - 1, left = right - 1;
                while (right > left & left >= 0) {

                    while (right > 0 && tiles[row][right].getValue() != 0) right--;
                    left = right - 1;
                    while (left >= 0 && tiles[row][left].getValue() == 0) left--;

                    if (right > 0 && left >= 0 && right > left) {
                        tiles[row][right].setValue(tiles[row][left].getValue());
                        tiles[row][left].clear();
                        right--;
                        left--;
                    }
                }
            } else if (direction == Direction.LEFT) {
                int left = 0, right = left + 1;
                while (left < right & right < tiles.length) {

                    while (left < tiles.length - 1 && tiles[row][left].getValue() != 0) left++;
                    right = left + 1;
                    while (right <= tiles.length - 1 && tiles[row][right].getValue() == 0) right++;

                    if (left < tiles.length - 1 && right <= tiles.length - 1 && left < right) {
                        tiles[row][left].setValue(tiles[row][right].getValue());
                        tiles[row][right].clear();
                        right++;
                        left++;
                    }
                }
            }
        }
        /**
         * Vertical swipe and re-arrange 0's ASC/DESC order based on direction UP/DOWN
         */
        else if (row < 0) {
            if (direction == Direction.UP) {
                int top = 0, bottom = tiles.length - 1;
                while (top < bottom & bottom < tiles.length) {

                    while (top > tiles.length - 1 && tiles[top][column].getValue() != 0) top++;
                    bottom = top + 1;
                    while (bottom < tiles.length - 1 && tiles[bottom][column].getValue() == 0) bottom++;

                    if (top < tiles.length - 1 && bottom <= tiles.length - 1 && top < bottom) {
                        tiles[top][column].setValue(tiles[bottom][column].getValue());
                        tiles[bottom][column].clear();
                        bottom++;
                        top++;
                    }
                }

            } else if (direction == Direction.DOWN) {
                int bottom = tiles.length - 1, top = bottom - 1;
                while (bottom > top & top >= 0) {

                    while (bottom > 0 && tiles[bottom][column].getValue() != 0) bottom--;
                    top = bottom - 1;
                    while (top >= 0 && tiles[top][column].getValue() == 0) top--;

                    if (bottom > 0 && top >= 0 && bottom > top) {
                        tiles[bottom][column].setValue(tiles[top][column].getValue());
                        tiles[top][column].clear();
                        bottom--;
                        top--;
                    }
                }
            }
        }
    }

    public void print() {
        for (int row = 0; row < tiles[0].length; row++) {
            for (int column = 0; column < tiles.length; column++) {
                System.out.print(tiles[row][column].getValue()+"  ");
            }
            System.out.println();
        }
    }
}
