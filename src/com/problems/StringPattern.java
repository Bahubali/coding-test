package com.problems;

/**
 * Created by bahubali.n on 27/01/19.
 */
public class StringPattern {
    public static void main(String[] args) {
        String pattern = "CGC";
        int hashOfPattern = hashCode(pattern);
        String inputStr = "GACGCCA";
        System.out.println(substringExist(inputStr, pattern, hashOfPattern));
    }

    public static boolean substringExist(String inputStr, String pattern, int hashCode) {
        int j = pattern.length() - 1, start = 0;
        boolean isMatched = false;
        while (start < (inputStr.length() - j)) {
            String str = inputStr.substring(start, (pattern.length() + start));
            if (hashCode(str) == hashCode) {
                if (checkCharMatch(str, pattern)) isMatched = true;
            }
            start++;
        }
        return isMatched;
    }

    private static boolean checkCharMatch(String substr, String pattern) {
        for (int i = 0; i < substr.length(); i++) {
            if (substr.charAt(i) != pattern.charAt(i)) return false;
        }
        return true;
    }

    private static int hashCode(String pattern) {
        int hash = 0;
        for (int i = pattern.length() - 1; i >= 0; i--) {
            hash += (pattern.charAt(i) - 'A' + 1) * powerOf(10, (pattern.length() - 1 - i));
        }
        return hash;
    }

    private static int powerOf(int base, int power) {
        if (power == 0) {
            return 1;
        } else {
            return base * powerOf(base, power - 1);
        }
    }
}
