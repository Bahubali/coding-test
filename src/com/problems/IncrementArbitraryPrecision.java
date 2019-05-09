package com.problems;

import java.util.*;

/**
 * Created by bahubali.n on 24/12/18.
 */
public class IncrementArbitraryPrecision {

    public static void plusOne(List<Integer> A) {
        int carry = 3, i = A.size() - 1;
        while (i >= 0 && carry > 0) {
            int sum = A.get(i) + carry;
            int mod = sum % 10;
            if (mod >= 0) {
                carry = sum / 10;
                A.set(i, mod);
                i--;
            }
        }
    }

    public static List<Integer> bitwisePlus(List<Integer> A, List<Integer> B) {

        if (A.size() >= B.size()) {
            int carry = 0, i = A.size() - 1;

            while (i >= 0) {
                int sum = A.get(i) + B.get(i) + carry;
                int mod = sum % 2;
                if (mod >= 0) {
                    carry = sum / 2;
                };
                A.set(i, mod);
                i--;
            }
            System.out.println();
        }
        return A;
    }

    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size()+num2.size(), 0));
        for (int i = num1.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                result.set(i+j+1, result.get(i+j+1)+num1.get(i)*num2.get(j));
                result.set(i+j, result.get(i+j)+result.get(i+j+1)/10);
                result.set(i+j+1, result.get(i+j+1)%10);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> abArray = Arrays.asList(1, 2, 3);
        List<Integer> aaArray = Arrays.asList(9, 8, 7);
        IncrementArbitraryPrecision.multiply(abArray, aaArray).stream().forEach(i -> System.out.println(i));
        //abArray.stream().forEach(i -> System.out.println(i));
    }

}
