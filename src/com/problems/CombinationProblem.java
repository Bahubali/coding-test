package com.problems;

/**
 * Created by bahubali.n on 10/01/19.
 */
public class CombinationProblem {

    public static void main(String[] args) {
        int[] inputArray = {2, 5, 8, 4, 6, 11};
        int combinationOf = 2;
        printCombination(inputArray, combinationOf);
    }

    public static void printCombination(int[] inputArray, int combinationOf) {
        int[] data = new int[combinationOf];
        combinationUtil(inputArray, data, 0, inputArray.length-1, 0, combinationOf);

    }

    public static void combinationUtil(int[] inputArray, int[] data, int start, int end, int index, int k) {
        if (index == k) {
            for (int j = 0; j < data.length; j++) {
                System.out.print(data[j]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= end && end-i+1 >= k - index; i++) {
            data[index] = inputArray[i];
            combinationUtil(inputArray, data, i+1, end, index+1, k);
        }
    }

}
