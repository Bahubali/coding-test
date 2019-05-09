package com.problems;

public class PalindromeCheck {
    public static void main(String[] args) {
        String inputStr = "cbdbcaa";
        inputStr = inputStr.concat(inputStr);
        System.out.print("Is str palindrome? - "
                +PalindromeCheck.isPalindrome(inputStr));
    }

    private static boolean isPalindrome(String inputStr) {
        int i = 0, j = inputStr.length() - 1;
        boolean prevMatch = false;
        while (i < j) {
            if (inputStr.charAt(i) != inputStr.charAt(j)) {
                if (prevMatch == true) return false;
                j--;
            }
            if (inputStr.charAt(i) == inputStr.charAt(j)) {
                prevMatch = true;
                i++;
                j--;
            }
        }
        return prevMatch;
    }
}