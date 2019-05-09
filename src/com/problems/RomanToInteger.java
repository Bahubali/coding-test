package com.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bahubali.n on 26/01/19.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(convertRomanToInteger("CIC"));
    }

    public static int convertRomanToInteger(String romanNum) {
        Map<Character, Integer> romanMap = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int sum = romanMap.get(romanNum.charAt(romanNum.length() - 1));
        for (int i = romanNum.length() - 2; i >= 0; i--) {
            if (romanMap.get(romanNum.charAt(i)) < romanMap.get(romanNum.charAt(i+1))) {
                sum = sum - romanMap.get(romanNum.charAt(i));
            } else {
                sum += romanMap.get(romanNum.charAt(i));
            }
        }

        return sum;
    }
}
