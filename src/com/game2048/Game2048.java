package com.game2048;

/**
 * Created by bahubali.n on 15/01/19.
 */
public class Game2048 {

    public static void main(String[] args) {
        int gridSize = 4;
        Grid grid = new Grid();
        grid.addTile(1, 0, new Tile(2));
        grid.addTile(1, 2, new Tile(2));
        grid.print();
        grid.move(Direction.RIGHT);
        System.out.println("After swipe to RIGHT:");
        grid.print();
        grid.addTile(1, 1, new Tile(2));
        System.out.println("New Tile Added ");
        grid.print();
        grid.move(Direction.RIGHT);
        System.out.println("After swipe to RIGHT:");
        grid.print();
        grid.addTile(1, 1, new Tile(2));
        System.out.println("New Tile Added ");
        grid.print();
        grid.move(Direction.RIGHT);
        System.out.println("After swipe to RIGHT:");
        grid.print();
        grid.move(Direction.LEFT);
        System.out.println("After swipe to LEFT:");
        grid.print();
        grid.addTile(1, 1, new Tile(8));
        System.out.println("New Tile Added ");
        grid.print();
        grid.move(Direction.RIGHT);
        System.out.println("After swipe to LEFT:");
        grid.print();
        grid.addTile(2, 3, new Tile(4));
        System.out.println("New Tile Added ");
        grid.print();
        grid.move(Direction.LEFT);
        System.out.println("After swipe to LEFT:");
        grid.print();
        grid.move(Direction.DOWN);
        System.out.println("After swipe to DOWN:");
        grid.print();
        grid.addTile(3, 3, new Tile(4));
        System.out.println("New Tile Added ");
        grid.print();
        grid.move(Direction.RIGHT);
        System.out.println("After swipe to RIGHT:");
        grid.print();
        grid.addTile(3, 2, new Tile(4));
        System.out.println("New Tile Added ");
        grid.print();
        grid.addTile(3, 1, new Tile(4));
        System.out.println("New Tile Added ");
        grid.print();
        grid.move(Direction.RIGHT);
        System.out.println("After swipe to RIGHT:");
        grid.print();
        grid.move(Direction.RIGHT);
        System.out.println("After swipe to RIGHT:");
        grid.print();
        grid.move(Direction.DOWN);
        System.out.println("After swipe to DOWN:");
        grid.print();
    }
}
