package com.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bahubali.n on 26/12/18.
 */
public class DeleteDuplicatesInArray {

    public static void main(String[] args) {

        List<Integer> inputArray = Arrays.asList(2,3,5,5,5,7,7,11,11,11,11, 11,13);
        duplicateMin(inputArray);
        inputArray.stream().forEach(System.out::println);
    }

    public static void bruteForceSolution(List<Integer> inputArray) {
        for (int i = 0; i < inputArray.size() - 1; i++) {
            int xorNum = inputArray.get(i) ^ inputArray.get(i+1);
            if (xorNum == 0) {
                inputArray.set(i, 0);
            }
        }
    }

    public static void diffAlgorithm(List<Integer> inputArray) {
        int write = 1;
        for (int i = 1; i < inputArray.size(); ++i) {
            if (!inputArray.get(write-1).equals(inputArray.get(i))) {
                inputArray.set(write++, inputArray.get(i));
            }
        }
    }

    public static void duplicateMin(List<Integer> inputArray) {
        int prevResult = Integer.MAX_VALUE;
        for (int i = 1; i < inputArray.size() - 1; i++) {
            int isDuplicate = inputArray.get(i) ^ inputArray.get(i-1);
            if (isDuplicate == 0) {
                if (prevResult != 0) {
                    prevResult = isDuplicate;
                } else {
                    inputArray.set(i - 1, 0);
                }
            } else {
                prevResult = Integer.MAX_VALUE;
            }
        }
    }
}
