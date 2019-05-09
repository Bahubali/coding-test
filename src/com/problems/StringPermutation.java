package com.problems;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bahubali.n on 07/01/19.
 */
public class StringPermutation {

    public static void main(String[] args) {
        String input = "AABC";
        StringPermutation.permute(input);
    }

    public static void permute(String input) {
        char[] inputCharArray = input.toCharArray();

        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : inputCharArray) {
            countMap.compute(ch , (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    val += 1;
                }
                return val;
            });
        }

        char[] str = new char[countMap.size()];
        int[] count = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> ch : countMap.entrySet()) {
            str[index] = ch.getKey();
            count[index] = ch.getValue();
            index++;
        }
        char[] result = new char[input.length()];
        permuteHelper(str, count, result, 0);
    }

    public static void permuteHelper(char[] str, int[] count, char[] result, int level) {
        if (level == result.length) {
            for (char ch : result)
                System.out.print(ch);
            System.out.println();

            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (count[i] == 0) continue;

            result[level] = str[i];
            count[i]--;
            permuteHelper(str, count, result, level+1);
            count[i]++;
        }
    }
}
