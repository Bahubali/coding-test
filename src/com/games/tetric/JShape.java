package com.games.tetric;

import com.splitwise.UserRegistry;

public class JShape extends AbstractShape {

    enum JShapeType {
        TYPE_1, TYPE_2;
    }
    private int[][] shape;
    private JShapeType type;
    JShape(int rows, int columns, JShapeType type) {
        super(rows, columns);
        this.type = type;
    }

    @Override
    public int[][] getShape() {
        switch (this.type) {
            case TYPE_1:
                this.shape = new int[][]{{0, 1}, {0, 1},{1, 1}};
                break;
            case TYPE_2:
                this.shape = new int[][]{{1, 1}, {1, 0},{1, 0}};
                break;
            default:

        }
        return this.shape;
    }
}
