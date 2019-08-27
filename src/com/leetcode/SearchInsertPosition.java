package com.leetcode;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] inputArray = {1, 3, 6, 8};
        int searchKey = 7;
        System.out.println("Insert Position: "+findInsertPosition(inputArray, searchKey));
    }

    public static int findInsertPosition(int[] nums, int target) {
        if (nums.length <= 1) {
            if (nums.length == 0) return 0;
            else if (nums[0] == target) return 0;
            else return (nums[0] > target)? 0 : 1;
        } else {
            int pivot = findPivot(nums, 0, nums.length - 1, target);
            if (pivot > nums.length - 1) return pivot;
            return (nums[pivot] < target && nums[pivot+1] > target)? pivot+1 : pivot;
        }
    }

    public static int findPivot(int[] nums, int l, int r, int searchKey) {
        if (l <= r) {
            int mid = l + (r - l)/2;
            if (nums[mid] == searchKey) return mid;
            else if (nums[mid] > searchKey) {
                return findPivot(nums, l, mid - 1, searchKey);
            } else {
                return findPivot(nums, mid+1, r, searchKey);
            }
        }
        return l;
    }
}
