package com.algorithm;

import java.util.Arrays;

/**
 * Created by bahubali.n on 29/12/16.
 */
public class MergeSortAlgorithm {

    public static void main(String[] args) throws Exception{
        int[] givenArray = {10, 2, 7, 5, 17, 1, 9, 25};
        MergeSortAlgorithm.sortArray(givenArray);
        for (int i = 0; i < givenArray.length; i++)
            System.out.println(givenArray[i]);
    }

    public static void sortArray(int[] inputArray) {
        int sizeOfArray = inputArray.length;
        int mid = sizeOfArray/2;
        if (sizeOfArray < 2) return;

        int[] leftArray = Arrays.copyOfRange(inputArray, 0, mid);
        int[] rightArray = Arrays.copyOfRange(inputArray, mid, sizeOfArray);

        MergeSortAlgorithm.sortArray(leftArray);
        MergeSortAlgorithm.sortArray(rightArray);
        MergeSortAlgorithm.merge(leftArray, rightArray, inputArray);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] outputArray) {
        int sizeOfLeftArray = leftArray.length;
        int sizeOfRightArray = rightArray.length;

        int i = 0, j = 0, k = 0;

        while (i < sizeOfLeftArray && j < sizeOfRightArray) {
            if(leftArray[i] <= rightArray[j])
                outputArray[k++] = leftArray[i++];
            else
                outputArray[k++] = rightArray[j++];
        }

        while (i < sizeOfLeftArray)
            outputArray[k++] = leftArray[i++];
        while (j < sizeOfRightArray)
            outputArray[k++] = rightArray[j++];
    }
}
