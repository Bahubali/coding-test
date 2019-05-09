package com.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 11/01/19.
 */
public class SpiralOrdering2DArray {
    public static void main(String[] args) {
        int[][] dArray = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        List<Integer> spiralArray = new ArrayList<>();
        spiralOrder(dArray, dArray.length, dArray.length);
    }

    public static void spiralOrder(int[][] dArray, int rows, int columns) {
        int top = 0, left = 0, bottom = rows - 1, right = columns - 1;
        int direction = 0;
        while (left <= right && top <= bottom) {
            if (direction == 0) {
                for (int k = left; k <= right; k++)
                    System.out.print(dArray[top][k]+" ");
                top++;
            } else if (direction == 1) {
                for (int k = top; k <= bottom; k++)
                    System.out.print(dArray[k][right]+" ");
                right--;
            } else if (direction == 2) {
                for (int k = right; k >= left; k--)
                    System.out.print(dArray[bottom][k]+" ");
                bottom--;
            } else if (direction == 3) {
                for (int k = bottom; k >= top; k--)
                    System.out.print(dArray[k][left]+" ");
                left++;
            }
            direction = (direction+1)%4;
        }
    }
}
