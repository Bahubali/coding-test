package com.flipkart.cube;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RubiksCube {

    private Map<SideType, Side> rubikSides;
    private static int ROWS = 3;
    private static int COLUMNS = 3;
    private LinkedList<Side> xAxis;
    RubiksCube() {
        this.rubikSides = new HashMap<>();
        this.initRubik();
    }

    private void initRubik() {
        this.rubikSides.put(SideType.TOP, new Side(ROWS, COLUMNS, 1));
        this.rubikSides.put(SideType.LEFT, new Side(ROWS, COLUMNS, 2));
        this.rubikSides.put(SideType.FRONT, new Side(ROWS, COLUMNS, 3));
        this.rubikSides.put(SideType.RIGHT, new Side(ROWS, COLUMNS, 4));
        this.rubikSides.put(SideType.BACK, new Side(ROWS, COLUMNS, 5));
        this.rubikSides.put(SideType.BOTTOM, new Side(ROWS, COLUMNS, 6));
    }

    private void initXAxis() {
        this.xAxis = new LinkedList<>();
        this.xAxis.add(this.rubikSides.get(SideType.TOP));
        this.xAxis.add(this.rubikSides.get(SideType.BACK));
        this.xAxis.add(this.rubikSides.get(SideType.BOTTOM));
        this.xAxis.add(this.rubikSides.get(SideType.FRONT));
    }
    public void rotateLayer(char axis, int layer, int degree) {
        int row, column;
        while (degree > 0) {
            switch (axis) {
                case 'x':
                    column = layer - 1;
                    for (row = 0; row < 3; row++) {
                        int tmp = this.rubikSides.get(SideType.TOP).getVal(row,column);
                        this.rubikSides.get(SideType.TOP).setVal(
                                row, column, this.rubikSides.get(SideType.BACK).getVal(row, column)
                        );
                        this.rubikSides.get(SideType.BACK).setVal(
                                row, column, this.rubikSides.get(SideType.BOTTOM).getVal(row, column)
                        );
                        this.rubikSides.get(SideType.BOTTOM).setVal(
                                row, column, this.rubikSides.get(SideType.FRONT).getVal(row, column)
                        );
                        this.rubikSides.get(SideType.FRONT).setVal(
                                row, column, tmp
                        );
                    }
                    if (layer == 1 || layer == 3) {
                        this.rubikSides.get(SideType.LEFT).rotateClockWise();
                    }
                    break;
                case 'y':
                    row = layer - 1;
                    for (column = 0; column < 3; column++) {
                        int tmp = this.rubikSides.get(SideType.LEFT).getVal(row,column);
                        this.rubikSides.get(SideType.LEFT).setVal(
                                row, column, this.rubikSides.get(SideType.BACK).getVal(row, column)
                        );
                        this.rubikSides.get(SideType.BACK).setVal(
                                row, column, this.rubikSides.get(SideType.RIGHT).getVal(row, column)
                        );
                        this.rubikSides.get(SideType.RIGHT).setVal(
                                row, column, this.rubikSides.get(SideType.FRONT).getVal(row, column)
                        );
                        this.rubikSides.get(SideType.FRONT).setVal(
                                row, column, tmp
                        );
                    }
                    break;
            }
            degree--;
        }
    }

    public void rotateCube(char axis, int degree) {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                int tmp = this.rubikSides.get(SideType.LEFT).getVal(row,column);
                this.rubikSides.get(SideType.LEFT).setVal(
                        row, column, this.rubikSides.get(SideType.BACK).getVal(row, column)
                );
                this.rubikSides.get(SideType.BACK).setVal(
                        row, column, this.rubikSides.get(SideType.RIGHT).getVal(row, column)
                );
                this.rubikSides.get(SideType.RIGHT).setVal(
                        row, column, this.rubikSides.get(SideType.FRONT).getVal(row, column)
                );
                this.rubikSides.get(SideType.FRONT).setVal(
                        row, column, tmp
                );
            }
        }
    }

    public void print() {
        this.rubikSides.get(SideType.TOP).print();
        this.rubikSides.get(SideType.LEFT).print();
        this.rubikSides.get(SideType.FRONT).print();
        this.rubikSides.get(SideType.RIGHT).print();
        this.rubikSides.get(SideType.BACK).print();
        this.rubikSides.get(SideType.BOTTOM).print();
    }

    public static void main(String[] args) {
        RubiksCube cube = new RubiksCube();
        cube.rotateCube('x', 1);
        cube.print();
    }
}
