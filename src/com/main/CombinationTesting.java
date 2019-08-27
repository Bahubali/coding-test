package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationTesting {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        List<List<Integer>> combinationSum = new ArrayList<>();
        combinationSumUtil(nums, new ArrayList<>(), 0, 0,7, combinationSum);
        combinationSum.stream().forEach(System.out::println);

    }

    public static void combinationSumUtil(int[] nums, List<Integer> levelResult, int level, int maxSoFar, int target, List<List<Integer>> finalResult) {
        if (maxSoFar == target) {
            List<Integer> copyOfResult = new ArrayList<>();
            levelResult.stream().forEach(num -> copyOfResult.add(num));
            finalResult.add(copyOfResult);
        } else {
            for (int i = level; i < nums.length; i++) {
                maxSoFar += nums[i];
                if (maxSoFar <= target) {
                    levelResult.add(nums[i]);
                    combinationSumUtil(nums, levelResult, level, maxSoFar, target, finalResult);
                    maxSoFar -= nums[i];
                    if (levelResult.size() > 0)
                        levelResult.remove(levelResult.size() - 1);
                }
                level += 1;
            }
        }
    }
}
