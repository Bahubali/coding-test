package com.leetcode;

import java.util.Arrays;

public class FindMissingPositive {

    public static void main(String[] args) {

        int[] nums = {3,4,-1,1};
        nums = separateNonNegFromNegNum(nums);
        nums = makePosToNegNum(nums);
        int iMissingNum = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0) {
                iMissingNum = k;
                break;
            }
        }
        if (iMissingNum < 0) iMissingNum = nums.length - 1;

        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        System.out.println(iMissingNum+1);
    }

    public static int[] separateNonNegFromNegNum(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] > 0) i++;
            else if (nums[j] < 0) j--;
            else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }

    public static int[] makePosToNegNum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x < nums.length && x > 0) {
                nums[x-1] = -1 * Math.abs(nums[x-1]);
            }
        }
        return nums;
    }
}
