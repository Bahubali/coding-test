package com.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 22/01/19.
 */
public class PhoneMnemonics {

    private static final String[] MAPPING = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};;

    public static void main(String[] args) {

        String phoneNumber = "234";
        char[] partialMnemonics = new char[phoneNumber.length()];
        List<String> mnemonics = new ArrayList<>();
        phoneMnemonicsHelper(phoneNumber, 0, partialMnemonics, mnemonics);
        mnemonics.stream().forEach(System.out::println);
    }

    public static void phoneMnemonicsHelper(String phoneNumber, int digit, char[] partialMnemonic, List<String> mnemonics) {
        if (digit == phoneNumber.length()) {
            // base case
            mnemonics.add(new String(partialMnemonic));
        } else {
            //recursive case
            for (int i = 0; i < MAPPING[phoneNumber.charAt(digit) - '0'].length(); i++) {
                char chosenChar = MAPPING[phoneNumber.charAt(digit) - '0'].charAt(i);
                partialMnemonic[digit] = chosenChar;
                phoneMnemonicsHelper(phoneNumber, digit+1, partialMnemonic, mnemonics);
            }
        }
    }
}
