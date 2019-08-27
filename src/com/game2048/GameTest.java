package com.game2048;

import java.util.Arrays;

public class GameTest {
    public static void main(String[] args) {
        int[] inputArray = {4, 0, 0, 2};
        inputArray = swipeLeft(inputArray);

        Arrays.stream(inputArray).forEach(System.out::print);
    }

    public static int[] swipeLeft(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0)
                nums[k++] = nums[i];
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
        return nums;
    }

    public static int[] swipeRight(int[] nums) {
        int k = nums.length - 1;
        for (int i = k; i >= 0 ; i--) {
            if (nums[i] != 0)
                nums[k--] = nums[i];
        }
        while (k >= 0) {
            nums[k--] = 0;
        }
        return nums;
    }
}
