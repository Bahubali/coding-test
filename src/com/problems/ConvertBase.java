package com.problems;

/**
 * Created by bahubali.n on 14/01/19.
 */
public class ConvertBase {

    public static void main(String[] args) {

        /**
         * Convert value to input base
         */
        String inputStr = "AAD";
        inputStr.concat(inputStr);
        int convertValueOf = 306;
        int convertToBase = 7;
        StringBuilder result = new StringBuilder();
        result = convertBase(convertValueOf, convertToBase, result);
        System.out.print(result.toString() + " base of "+convertToBase);
    }

    private static StringBuilder convertBase(int input, int baseTo, StringBuilder result) {
        int quotient, remainder;
        if (input > baseTo) {
            quotient = input / baseTo;
            convertBase(quotient, baseTo, result);
            remainder = input % baseTo;
            result.append(remainder);
        } else {
            quotient = input / baseTo;
            if (quotient > 0) result.append(quotient);
            result.append(input % baseTo);
        }
        return result;
    }

    public static int findSpreadSheetColNumber(String inputStr) {
        //String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int columnId = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            columnId = columnId * 26 + (c - 'A' + 1);
        }
        return columnId;
    }
}
