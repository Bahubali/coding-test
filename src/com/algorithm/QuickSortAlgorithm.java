package com.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bahubali.n on 20/12/18.
 */
public class QuickSortAlgorithm {

    public static void main(String[] args) {
        List<Integer> inputArray = Arrays.asList(7, 3, 2, 5, 1, 4, 6);
        QuickSortAlgorithm.quickSort(inputArray, 0, inputArray.size() - 1);
        inputArray.stream().forEach(System.out::println);
    }

    public static void quickSort(List<Integer> inputArray, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(inputArray, low, high);
            quickSort(inputArray, low, pivotIndex-1);
            quickSort(inputArray, pivotIndex+1, high);
        }
    }

    public static int partition(List<Integer> inputArray, int start, int end) {
        int pivot = inputArray.get(end), j = 0, i = (start - 1);
        for (j = start; j <= end - 1; j++) {
            if (inputArray.get(j) <= pivot) {
                i++;
                Collections.swap(inputArray, i, j);
            }
        }
        Collections.swap(inputArray, i+1, end);

        return (i + 1);
    }
}
