package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bahubali.n on 05/01/19.
 */
public class Permutation {

    public static void main(String[] args) {
        String inputString = "ABCD";
        int length = inputString.length();
        //int[] arr = {1, 2, 3};
        List<Integer> integerArray = Arrays.asList(0, 1, 2, 3);
        //Permutation.permuteNumbers(integerArray, 0, integerArray.size()-1);
        //Permutation.permute(inputString, 0, inputString.length()-1);
        ArrayList<String> result = new ArrayList<String>();
        permuteString("", inputString, result);
        System.out.println(result.toString());
        //result.stream(System.out::println);
        //Permutation.nextPermutation(arr);
        //int[] p = {4, 3, 2, 0, 1};
        //arr = Permutation.nextPermutation(arr);
        //for (int i = 0; i <= arr.length - 1; i++)
            //System.out.print(arr[i]);
    }

    public static void permute(String inputString, int l, int r) {
//        Permutation.indent(l);
//        System.out.println("permute("+inputString.toString()+","+l+","+r);
        if (l == r) System.out.println(inputString);

        for (int i = l; i <= r; ++i) {
            inputString = swap(inputString, l, i);
            permute(inputString, l+1, r);
            inputString = swap(inputString, l, i);
        }
    }

    public static void permuteString(String prefix, String suffix, ArrayList<String> results) {
        System.out.println("permuteString("+prefix+","+suffix);
        if (suffix.length() == 0) results.add(prefix);
        else {
            for (int i = 0; i < suffix.length(); i++) {

                permuteString(prefix+suffix.charAt(i), suffix.substring(0, i)+suffix.substring(i+1, suffix.length()), results);
            }
        }
    }

    private static void indent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }
    public static void permuteNumbers(List<Integer> inputArray, int l, int r) {
//        Permutation.indent(l);
//        System.out.println("permuteNumbers("+inputArray.toString()+","+l+","+r);
        if (l == r) System.out.println(inputArray.toString());

        for (int i = l; i <= r; ++i) {
            Collections.swap(inputArray, l, i);
            permuteNumbers(inputArray, l+1, r);
            Collections.swap(inputArray, l, i);
        }
    }

    private static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private static char[] swapCharArray(char[] charArray, int i, int j) {
        char temp;
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return charArray;
    }

    public static String applyPermutation(String str, int[] p) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != str.charAt(p[i])) {
                int end = p[i], start = i;
                while (end != i) {
                    charArray = swapCharArray(charArray, start, end);
                    start = end;
                    end = p[end];
                }
            }
        }
        return String.valueOf(charArray);
    }

    public static int[] nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i <= 0)
            return array;

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return array;
    }
}
