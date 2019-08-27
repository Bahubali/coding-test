package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class RainWaterTrap {

    public static void main(String[] args) {
        int[] nums = {1,7,3,1,5,6};
        //int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int waterTrap = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                int top = stack.pop();
                if (!stack.empty()) {
                    int distance = i - stack.peek() - 1;
                    int bounded_height = Math.min(nums[i], nums[stack.peek()]) - nums[top];
//                    while (distance > 0) {
//                        result[i-distance] = result[i-distance]+bounded_height;
//                        distance--;
//                    }
                    waterTrap += distance * bounded_height;
                }
            }
            //result[i] = 0;
            stack.push(i);
        }
        System.out.println("Water trapped: "+waterTrap);
        //Arrays.stream(result).forEach(System.out::print);
    }


    public static void trapWater2(int[][] heightMap) {

    }
}
