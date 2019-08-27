package com.leetcode;

public class SearchInSortedArray {
    public static void main(String[] args) {
        int[] inputArray = {2, 3, 4, 5, 1};
        int searchKey = 1;
        System.out.println(findInRevertedArray(inputArray, 0, inputArray.length-1, searchKey));
    }

    public static int findInRevertedArray(int[] nums, int l, int r, int searchKey) {
        if (nums.length <= 2) {
            if (nums.length == 0) return -1;
            else if (nums.length == 1) return (nums[0] == searchKey)? 0 : -1;
            else {
                return (nums[0] == searchKey)? 0 : (nums[1] == searchKey)? 1 : -1;
            }
        } else {
            int pivot = findPivot(nums, l, r);
            if (pivot == 0 || pivot == -1) return binarySearch(nums, l, r, searchKey);
            else if (nums[pivot] == searchKey) { return pivot; }
            else {
                if (nums[0] <= searchKey) return binarySearch(nums, l, pivot-1, searchKey);
                else return binarySearch(nums, pivot+1, r, searchKey);
            }
        }
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        else if (nums.length == 1) {
            return (nums[0] == target)? 0 : -1;
        } else {
            int found = -1;
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r-l)/2;
                if (nums[mid] == target) {
                    found = mid; break;
                } else if (nums[l] >= nums[r]) {
                    if (nums[mid] >= target && nums[l] <= target) r = mid - 1;
                    else l = mid + 1;
                } else {
                    if (nums[mid] > target) r = mid - 1;
                    else l = mid + 1;
                }
            }
            return found;
        }
    }


    public static int findPivot(int[] nums, int l, int r) {
        if (l > r) return -1;
        else if (l == r) return l;
        else {
            int mid = l + (r - l)/2;
            //if (mid == l) return -1;
            if (mid < r && nums[mid] > nums[mid+1]) return mid + 1;
            else if (mid == l && mid < r && nums[mid] < nums[mid+1]) return mid;
            else if (l < mid && nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) return mid;
            else if (mid > l && nums[mid-1] <= nums[mid] && nums[mid] <= nums[mid+1]) {
                if (nums[mid] < nums[r])
                    return findPivot(nums, l, mid-1);
                else return findPivot(nums, mid+1, r);
            } else {
                return findPivot(nums, mid+1, r);
            }
        }
    }

    public static int binarySearch(int[] nums, int l, int r, int key) {
        if (l <= r) {
            int mid = l + (r - l)/2;

            if (nums[mid] == key) return mid;
            else if (nums[mid] > key) {
                return binarySearch(nums, l, mid -1, key);
            } else {
                return binarySearch(nums, mid+1, r, key);
            }
        }
        return -1;
    }
}
