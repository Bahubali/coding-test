package com.problems;

/**
 * Created by bahubali.n on 24/01/19.
 */
public class LookAndSay {

    public static void main(String[] args) {
        System.out.println(lookAndSayNum(6));
    }

    public static String lookAndSayNum(int digitAt) {
        if (digitAt == 1) {
            //base case
            return "1";
        } else {
            String prev = lookAndSayNum(digitAt - 1);
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
