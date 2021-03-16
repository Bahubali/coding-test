package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstAndLastIndexInSortedArray {

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3};
        int[] result = findStartAndEndIndexOfElement(inputArray, 1);
        //Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] findStartAndEndIndexOfElement(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{-1, -1};
        } else {
            List<Integer> indexes = new ArrayList<Integer>();
            int pivotIndex = findPivot(nums, 0, nums.length-1, target);
            if (pivotIndex != -1) {
                while (nums[pivotIndex] == target) {
                    indexes.add(pivotIndex);
                    pivotIndex++;
                }
            }
            //return indexes.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[]{1};
    }

    public static int findPivot(int[] nums, int l, int r, int searchKey) {
        if (l <= r) {
            int mid = l + (r - l)/2;
            if (nums[mid] == searchKey) {
                if (l < mid && nums[mid-1] == searchKey) return findPivot(nums, l, mid-1, searchKey);
                else return mid;
            } else if (nums[mid] > searchKey) {
                return findPivot(nums, l, mid - 1, searchKey);
            } else {
                return findPivot(nums, mid+1, r, searchKey);
            }
        }
        return -1;
    }
}
