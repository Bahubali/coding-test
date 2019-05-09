package com.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 12/01/19.
 */
public class TwoDimensionalArray {

    public static void main(String[] args) {

        /**
         * Fill Matrix with spiral order
         */
//        int row = 3, column = 4;
//        int[][] squareMatrix = new int[row][column];
//        squareMatrix = fillSquareMatrix(squareMatrix, column, row);
//        for (int i = 0; i < row; ++i) {
//            System.out.println();
//            for (int j = 0; j < column; ++j) {
//                System.out.print(squareMatrix[i][j] + "   ");
//            }
//        }
//        System.out.println();
//
//        System.out.println(squareMatrix[row-2][column-2]);

        /**
         * Rotate Matrix
         */
//        int[][] inputMatrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int rows = 4, columns = 4;
//        int[][] resultMatrix = new int[columns][rows];
//        resultMatrix = rotateMatrixSimplified(inputMatrix, rows, columns);
//
//        for (int i = 0; i < columns; ++i) {
//            System.out.println();
//            for (int j = 0; j < rows; ++j) {
//                System.out.print(resultMatrix[i][j] + "   ");
//            }
//        }
//        System.out.println();

        /**
         * Pascal Triangle
         */
        List<List<Integer>> pascal = new ArrayList<>();
        int row = 10;
        pascal = generatePascalTriangle(row);

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print(pascal.get(i).get(j)+"  ");
            }
            System.out.println();
        }

    }

    public static int[][] fillSquareMatrix(int[][] resultMatrix, int rows, int columns) {
        int left = 0, right = rows - 1, top = 0, bottom = columns - 1;
        int direction = 0, val = 1;
        while (left <= right && top <= bottom) {
            if (direction == 0) {
                for (int k = left; k <= right; ++k) {
                    System.out.print(resultMatrix[top][k] = val);
                    val += 1;
                }
                top++;
            } else if (direction == 1) {
                for (int k = top; k <= bottom; ++k) {
                    System.out.print(resultMatrix[k][right] = val);
                    val += 1;
                }
                right--;
            } else if (direction == 2) {
                for (int k = right; k >= left; --k) {
                    System.out.print(resultMatrix[bottom][k] = val);
                    val += 1;
                }
                bottom--;
            } else if (direction == 3) {
                for (int k = bottom; k >= top; --k) {
                    System.out.print(resultMatrix[k][left] = val);
                    val += 1;
                }
                left++;
            }
            direction = (direction+1)%4;
        }
        System.out.println();
        return resultMatrix;
    }

    public static int[][] rotateMatrix(int[][] inputMatrix, int rows, int columns) {
        int[][] resultMatrix = new int[columns][rows];
        int columnStart = rows - 1;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (columnStart >= 0) {
                    resultMatrix[j][columnStart] = inputMatrix[i][j];
                }
            }
            columnStart--;
        }
        return resultMatrix;
    }

    public static int[][] rotateMatrixSimplified(int[][] inputMatrix, int rows, int columns) {
        int[][] resultMatrix = new int[columns][rows];
        int columnEnd = rows - 1, rowStart = 0;
        int k = 0;
        while (rowStart <= columnEnd) {
            resultMatrix[k][columnEnd] = inputMatrix[rowStart][k];
            resultMatrix[k][rowStart] = inputMatrix[columnEnd][k];
            k++;
            if (k == rows) {
                k = k%rows;
                rowStart++;
                columnEnd--;
            }
        }

        return resultMatrix;
    }

    public static List<List<Integer>> generatePascalTriangle(int rows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < rows; ++i) {
            List<Integer> curRow = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                curRow.add(
                        (0 < j && j < i)? pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j) : 1);
            }
            pascalTriangle.add(curRow);
        }
        return pascalTriangle;
    }
}
