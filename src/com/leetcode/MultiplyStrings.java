package com.leetcode;

import java.util.Arrays;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println("Sum: "+multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        int[] result = new int[num1.length()+num2.length()+1];
        result[result.length-1] = 0;
        int sumLength = result.length - 1;
        int loop = 0;
        for (int i = num1.length()-1; i >= 0; i--) {
            sumLength = result.length - loop - 1;
            int a = (int) num1.charAt(i) - '0';
            for (int j = num2.length()-1; j >= 0; j--) {
                int b = (int) num2.charAt(j) - '0';
                int digitSum = result[sumLength] + (a * b);
                int digitQuotient = digitSum / 10;
                int digitReminder = digitSum % 10;
                result[sumLength] = digitReminder;
                result[sumLength-1] = result[sumLength-1] + digitQuotient;
                sumLength--;
            }
            loop++;
        }
        StringBuilder finalResult = new StringBuilder();
        final boolean[] skipZero = {false};
//        Arrays.stream(result).forEach(num -> {
//            if (skipZero[0])
//                finalResult.append(Integer.toString(num));
//            skipZero[0] = (num > 0 && skipZero[0] == false)? true : false;
//        }
//        );
        return finalResult.toString();
    }
}
