package com.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 7, 8, 1, 4, 6};

    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
    }
}
