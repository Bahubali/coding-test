package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bahubali.n on 10/01/19.
 */
public class CombinationProblem {

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 4};
        int targetSum = 7;
        combinationSum(inputArray, targetSum);
    }

    public static void printCombination(int[] inputArray, int target) {
        int[] data = new int[target];
        combinationUtil(inputArray, data, 0, inputArray.length-1, 0, target, 0);

    }

    public static void combinationUtil(int[] inputArray, int[] data, int start, int end, int index, int k, int maxSoFar) {
        if (maxSoFar == 7) {
            for (int j = 0; j < data.length; j++) {
                if (data[j] > 0)
                    System.out.print(data[j]+" ");
            }
            System.out.println();
            return;
        } else if (index == k) {
            return;
        } else {
            for (int i = 0; i <= end; i++) {
                data[index] = inputArray[i];
                maxSoFar += inputArray[i];
                if (maxSoFar <= 7) {
                    combinationUtil(inputArray, data, i + 1, end, index + 1, k, maxSoFar);
                }
                maxSoFar -= inputArray[i];
                data[index] = 0;
            }
        }
    }

    public static void combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinationSum = new ArrayList<>();

        combinationSumUtil(candidates, target, new int[candidates.length], 0, 0, combinationSum);
        combinationSum.stream().forEach(System.out::println);
        //return combinationSum;
    }

    public static void combinationSumUtil(int[] nums, int target, int[] values, int level,
        int maxSumSoFar, List<List<Integer>> combinationSum) {
        if (maxSumSoFar == target) {
            combinationSum.add(Arrays.stream(values).filter(num -> num > 0).boxed().collect(Collectors.toList()));
        } else if (level == nums.length) return;
        else {
            for (int i = level; i < nums.length; i++) {
                values[level] = nums[i];
                maxSumSoFar += nums[i];
                if (maxSumSoFar <= 7)
                    combinationSumUtil(nums, target, values, level+1, maxSumSoFar, combinationSum);
                maxSumSoFar -= nums[i];
                values[level] = 0;
            }
        }
    }

}
