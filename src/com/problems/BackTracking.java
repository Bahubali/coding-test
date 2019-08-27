package com.problems;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by bahubali.n on 19/01/19.
 */
public class BackTracking {

    public static void main (String[] args) {
        //code
        //List<Integer> diceChoices = new ArrayList<>();
        //diceRoll(3, diceChoices);
        String str = "AABC";
        permute(str);
        //diceSum(4, 8, 0, diceChoices);
        //printBinaryHelper(3, "");
    }

    public static void indent(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("    ");
    }
    public static void printBinaryHelper(int digits, String prefix) {
        indent(prefix.length());
        System.out.println("printBinaryHelper("+digits+","+prefix+")");
        if (digits == 0) {
            System.out.println(prefix);
        } else {
            printBinaryHelper(digits - 1, prefix+"0");
            printBinaryHelper(digits - 1, prefix+"1");
        }
    }

    public static void printDecimal(int digits, String prefix) {
        //indent(prefix.length());
        //System.out.println("printDecimal("+digits+","+prefix+")");
        if (digits == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i <= 9; i++) {
                printDecimal(digits - 1, prefix+i);
            }
        }
    }

    public static void diceRoll(int dices, List<Integer> choices) {
        if (dices == 0){
            System.out.println(choices.toString());
        } else {
            for (int i = 1; i <= 6; i++) {
                choices.add(i);
                diceRoll(dices - 1, choices);
                choices.remove(choices.size() - 1);
            }
        }
    }

    public static void diceSum(int dices, int desiredSum, int sumSoFar, List<Integer> choices) {
        if (dices == 0) {
            System.out.println(choices.toString());
        } else {
            for (int i = 1; i <= 6; i++) {
                // chose/explore/un-chose

                if (sumSoFar+i+1*(dices - 1) <= desiredSum &&
                    sumSoFar+i+6*(dices - 1) >= desiredSum) {
                    choices.add(i);
                    diceSum(dices - 1, desiredSum, sumSoFar+i, choices);
                    choices.remove(choices.size() - 1);
                }
            }
        }
    }


    public static void permute(String inputStr) {
        //char[] charArray = inputStr.toCharArray();
        //char[] charChosen = new char[charArray.length];
        permuteHelper(inputStr, "");
    }

    public static void permuteHelper(String inputStr, String charChosen) {
        if (inputStr.length() == 0) {
            System.out.println(charChosen);
        } else {
            for (int i = 0; i < inputStr.length(); i++) {
                String newCharChosen = charChosen + inputStr.charAt(i);
                String remaining = inputStr.substring(0, i) + inputStr.substring(i+1);
                permuteHelper(remaining, newCharChosen);
                inputStr = charChosen.substring(charChosen.length() - 1 - i, charChosen.length())+inputStr;
                charChosen = charChosen.substring(i, charChosen.length() - 1 - i);
            }
        }
    }
}
