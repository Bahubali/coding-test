package com.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bahubali.n on 06/05/19.
 */
public class StringFrequency {

    public static void main(String[] args) {
        String inputStr = "aaabc";
        int digitsToRemove = 1;
        Map<Character, Integer> charOccurances = new HashMap<Character, Integer>();
        for (int i = 0; i < inputStr.length(); i++) {
            if (charOccurances.containsKey(inputStr.charAt(i))) {
                int frequency = charOccurances.get(inputStr.charAt(i)) - 'a'    ;
                charOccurances.put(inputStr.charAt(i), frequency);
            } else {
                charOccurances.put(inputStr.charAt(i), 1);
            }
        }

        int sum = 0;
        for (Character str : charOccurances.keySet()) {
            sum += charOccurances.get(str) * charOccurances.get(str);
        }

        System.out.println("Frequency of string: "+sum);
    }
}
