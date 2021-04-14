package com.flipkart;

public class Cube {

    private int[][] top = new int[3][3];
    private int[][] left = new int[3][3];;
    private int[][] front = new int[3][3];;
    private int[][] right = new int[3][3];;
    private int[][] back = new int[3][3];;
    private int[][] bottom = new int[3][3];;

    public Cube() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                top[i][j] = 1;
                left[i][j] = 2;
                front[i][j] = 3;
                right[i][j] = 4;
                back[i][j] = 5;
                bottom[i][j] = 6;
            }
        }
    }

    public void rotateLayer(char axis, int layer, int degree) {
        int column = layer - 1;
        while (degree > 0) {
            for (int row = 0; row < 3; row++) {
                int tmp = top[row][column];
                top[row][column] = back[row][column];
                back[row][column] = bottom[row][column];
                bottom[row][column] = front[row][column];
                front[row][column] = tmp;
            }
            degree--;
        }
    }

    public void print() {
        printSide(top);
        printSide(left);
        printSide(front);
        printSide(right);
        printSide(back);
        printSide(bottom);
    }

    private void rotateClockWise(int[][] side) {
        int n = 3;
        for (int row = 0; row < n/2; row++) {
            for (int column = 0; column < n-1-row; column--) {
                int temp = side[row][column];
                side[row][column] = side[n-1-column][row];
                side[n-1-column][row] = side[n-1-row][n-1-column];
                side[n-1-row][n-1-column] = side[column][n-1-row];
            }
        }
    }

    private void printSide(int[][] side) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(side[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.rotateLayer('x', 2, 2);
        cube.print();
    }
}
