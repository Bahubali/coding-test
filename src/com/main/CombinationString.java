package com.main;

public class CombinationString {

    public static void main(String[] args) {
        String inputStr = "abcd";
        combinationSets(inputStr, "", inputStr.length()-1);
    }

    public static void combinationSets(String inputStr, String set, int level) {
        if (level == 1) {
            System.out.println(set);
        } else {
            for (int i = 0; i < inputStr.length(); i++) {
                set += String.valueOf(inputStr.charAt(i));
                combinationSets(inputStr, set, level-1);
                //set.replace(set.charAt(set.length()-1), '');
            }
        }
    }
}
