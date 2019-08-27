package com.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CombinationSum {

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 4};
        int target = 7;
        combinationSum(inputArray, target).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinationSum = new ArrayList<>();
        if (candidates.length == 1) {
            List<Integer> list = (candidates[0] == target) ? Arrays.stream(candidates).boxed().collect(Collectors.toList()) : new ArrayList<>();
            if (!list.isEmpty()) combinationSum.add(list);
            return combinationSum;
        } else {
            Arrays.sort(candidates);
            combinationSumUtil2(candidates, new ArrayList<>(), 0, 0,0,target, combinationSum);
        }
        return combinationSum;
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
                } else break;
                level += 1;
            }
        }
    }


    public static void combinationSumUtil2(int[] nums, List<Integer> levelResult, int start, int level, int maxSoFar, int target, List<List<Integer>> finalResult) {
        if (maxSoFar == target) {
            List<Integer> copyOfResult = new ArrayList<>();
            levelResult.stream().forEach(num -> copyOfResult.add(num));
            finalResult.add(copyOfResult);
        } else {
            for (int i = start; i < nums.length; i++) {
                maxSoFar += nums[i];
                if (maxSoFar <= target) {
                    levelResult.add(nums[i]);
                    combinationSumUtil2(nums, levelResult, i+1, level+1, maxSoFar, target, finalResult);
                    maxSoFar -= nums[i];
                    if (levelResult.size() > 0)
                        levelResult.remove(levelResult.size() - 1);
                } else break;
                while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
    }
}
