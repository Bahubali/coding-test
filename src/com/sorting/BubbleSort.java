package com.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 7, 8, 1, 4, 6};
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        Arrays.stream(nums).forEach(System.out::print);
    }
}
