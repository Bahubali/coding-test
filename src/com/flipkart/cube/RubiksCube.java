package com.flipkart.cube;
import java.util.*;

public class RubiksCube {

    private Map<SideType, Side> rubikSides;
    private static int ROWS = 3;
    private static int COLUMNS = 3;
    private LinkedList<Side> xAxis;
    RubiksCube() {
        this.rubikSides = new HashMap<>();
        this.xAxis = new LinkedList<Side>();
        this.initRubik();
    }

    private void initRubik() {
        this.rubikSides.put(SideType.TOP, new Side(ROWS, COLUMNS, 1));
        this.rubikSides.put(SideType.LEFT, new Side(ROWS, COLUMNS, 2));
        this.rubikSides.put(SideType.FRONT, new Side(ROWS, COLUMNS, 3));
        this.rubikSides.put(SideType.RIGHT, new Side(ROWS, COLUMNS, 4));
        this.rubikSides.put(SideType.BACK, new Side(ROWS, COLUMNS, 5));
        this.rubikSides.put(SideType.BOTTOM, new Side(ROWS, COLUMNS, 6));
        this.initXAxis();
    }

    private void initXAxis() {
        this.xAxis.add(this.rubikSides.get(SideType.TOP));
        this.xAxis.add(this.rubikSides.get(SideType.BACK));
        this.xAxis.add(this.rubikSides.get(SideType.BOTTOM));
        this.xAxis.add(this.rubikSides.get(SideType.FRONT));
    }
    public void rotateLayer(Axis axis, int layer, int degree) {
        int row, column;
        while (degree != 0) {
            switch (axis) {
                case X:
                    column = layer - 1;
                    for (row = 0; row < 3; row++) {
                        Iterator iterator = (degree > 0)? this.xAxis.iterator() : this.xAxis.descendingIterator();
                        rotateAxis(row, column, iterator);
                    }
                    if (layer == 1 || layer == 3) {
                        this.rubikSides.get(SideType.LEFT).rotateClockWise();
                    }
                    break;
                case Y:
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
            degree = (degree > 0)? degree-1 : degree+1;
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

    private void rotateAxis(int row, int column, Iterator iterator) {
        Side previous = null;
        Side current = null;
        int temp = 0;
        while (iterator.hasNext()) {
            current = (Side) iterator.next();
            if (previous == null) {
                temp = current.getVal(row, column);
            } else {
                previous.setVal(row, column, current.getVal(row, column));
            }
            previous = current;
        }
        current.setVal(row, column, temp);
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
        //cube.rotateCube('x', Degree.P90.getVal());
        cube.rotateLayer(Axis.X, 2, Degree.P90.getVal());
        cube.print();
    }
}
