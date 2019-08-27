package com.leetcode;

public class CountAndSay {

    public static void main(String[] args) {
        lookAndSay(5);
    }

    public static String lookAndSay(int digitAt) {
        if (digitAt == 1) {
            //base case
            return "1";
        } else {
            String prev = lookAndSay(digitAt - 1);
            char prevChar = prev.charAt(0);
            int count = 1, k = 1;
            StringBuilder stringBuilder = new StringBuilder();
            while (k < prev.length()) {
                if (prev.charAt(k) != prevChar) {
                    stringBuilder.append(count);
                    stringBuilder.append(prevChar);
                    prevChar = prev.charAt(k);
                    count = 1;
                } else {
                    count++;
                }
                k++;
            }
            stringBuilder.append(count);
            stringBuilder.append(prevChar);
            return stringBuilder.toString();
        }

    }
}
