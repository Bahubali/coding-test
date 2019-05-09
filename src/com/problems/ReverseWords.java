package com.problems;

/**
 * Created by bahubali.n on 18/01/19.
 */
public class ReverseWords {

    public static void main(String[] args) {
        String inputWord = "My name is Bahubali";
        char[] inputWordArray = inputWord.toLowerCase().toCharArray();

        reverse(inputWordArray, 0, inputWordArray.length - 1);
        int start = 0, end = inputWordArray.length - 1;
        while ((end = find(inputWordArray, ' ', start)) != -1) {
            reverse(inputWordArray, start, end-1);
            start = end + 1;
        }
        reverse(inputWordArray, start, inputWordArray.length - 1);
        System.out.println(String.valueOf(inputWordArray));
    }

    public static void reverse(char[] charArray, int start, int end) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }

    public static int find(char[] charArray, char inputChar, int start) {
        int charAtIndex = start;
        while (charAtIndex < charArray.length) {
            if(charArray[charAtIndex] == inputChar) return charAtIndex;
            charAtIndex++;
        }
        return -1;
    }
}
