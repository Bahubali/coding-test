package com.problems;

/**
 * Created by bahubali.n on 17/01/19.
 */
public class AnagramCheck {
    public static void main (String[] args) {
        //code
        String word = "Listen";
        String anagram = "silent";
        System.out.println("Is Anagram: "+AnagramCheck.isAnagram(word, anagram));
    }

    public static boolean isAnagram(String word, String anagram) {
        boolean isAnagram = true;
        char[] charFromWord = word.toLowerCase().toCharArray();
        char[] charFromAnagram = anagram.toLowerCase().toCharArray();
        if (charFromAnagram.length != charFromWord.length) return false;

        for (int i = 0; i < charFromAnagram.length; i++) {
            int j = i; isAnagram = false;
            while (j < charFromWord.length && charFromAnagram[i] != charFromWord[j]) j++;

            if (j >= charFromWord.length) break;
            if (j == i) isAnagram = true;
            if (j > i) {
                char matchedChar = charFromWord[j];
                charFromWord[j] = charFromWord[i];
                charFromWord[i] = matchedChar;
                isAnagram = true;
            }

            if (!isAnagram) return false;
        }
        return isAnagram;
    }
}
