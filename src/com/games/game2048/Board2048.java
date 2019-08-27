package com.games.game2048;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board2048 extends Board {

    public static final int BOARD_SIZE = 4;
    private Panel[][] panels;

    public Board2048(int boardSize) {
        super(boardSize, boardSize);
        this.panels = new Panel[getRows()][getColumns()];
        initializeBoard();
        print();
    }

    @Override
    protected void initializeBoard() {
        for (int row = 0; row < getRows(); row++) {
            for (int column = 0; column < getColumns(); column++) {
                Panel panel = new Panel(new Position(row, column));
                if (panel.getPosition().getRow() == 0 && panel.getPosition().getColumn() == 0)
                    panel.setNumber(2);
                else panel.setNumber(0);
                this.panels[row][column] = panel;
            }
        }
    }

    public void addEntry(int num, Position position) throws Exception {
        Panel panel = this.panels[position.getRow()][position.getColumn()];
        if (panel != null && panel.getNumber() == 0) {
            panel.setNumber(num);
            System.out.println("Entry Added:");
            print();
        } else {
            throw new Exception("Invalid entry");
        }
    }
    public void swipe(Direction direction) {
        switch (direction) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
        }
        System.out.println("Swipe:"+direction.toString());
        print();
    }

    private void moveLeft() {
        for (int row = 0; row < getRows(); row++) {
            int[] rows = Arrays.stream(this.panels[row]).mapToInt(panel -> panel.getNumber()).toArray();
            rows = swipeLeft(rows);
            rows = mergeLeft(rows);
            rows = swipeLeft(rows);
            for (int column = 0; column < getColumns(); column++) {
                this.panels[row][column].setNumber(rows[column]);
            }
        }
    }


    private void moveRight() {
        for (int row = 0; row < getRows(); row++) {
            int[] rows = Arrays.stream(this.panels[row]).mapToInt(panel -> panel.getNumber()).toArray();
            rows = swipeRight(rows);
            rows = mergeRight(rows);
            rows = swipeRight(rows);
            for (int column = 0; column < getColumns(); column++) {
                this.panels[row][column].setNumber(rows[column]);
            }
        }
    }

    private void moveDown() {
        for (int column = 0; column < getColumns(); column++) {
            int[] columns = new int[getColumns()];
            for (int row = 0; row < getRows(); row++) {
                columns[row] = this.panels[row][column].getNumber();
            }
            columns = swipeRight(columns);
            columns = mergeRight(columns);
            columns = swipeRight(columns);
            for (int row = 0; row < getRows(); row++) {
                this.panels[row][column].setNumber(columns[row]);
            }
        }
    }

    private void moveUp() {
        for (int column = 0; column < getColumns(); column++) {
            int[] columns = new int[getColumns()];
            for (int row = 0; row < getRows(); row++) {
                columns[row] = this.panels[row][column].getNumber();
            }
            columns = swipeLeft(columns);
            columns = mergeLeft(columns);
            columns = swipeLeft(columns);
            for (int row = 0; row < getRows(); row++) {
                this.panels[row][column].setNumber(columns[row]);
            }
        }
    }

    public static int[] swipeLeft(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0)
                nums[k++] = nums[i];
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
        return nums;
    }

    public static int[] mergeLeft(int[] nums) {
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] == nums[i-1]) {
                nums[i] = nums[i] + nums[i - 1];
                nums[i-1] = 0;
            }
        }
        return nums;
    }


    public static int[] swipeRight(int[] nums) {
        int k = nums.length - 1;
        for (int i = k; i >= 0 ; i--) {
            if (nums[i] != 0)
                nums[k--] = nums[i];
        }
        while (k >= 0) {
            nums[k--] = 0;
        }
        return nums;
    }

    public static int[] mergeRight(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i-1]) {
                nums[i] = nums[i] + nums[i - 1];
                nums[i-1] = 0;
            }
        }
        return nums;
    }

    public void print() {
        for (int row = 0; row < this.panels[0].length; row++) {
            for (int column = 0; column < this.panels.length; column++) {
                System.out.print(this.panels[row][column].getNumber()+"  ");
            }
            System.out.println();
        }
        System.out.println("**** X ****");
        System.out.println();
    }
}
