package com.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class SegmentTree {

    static class Node {
        public int[] range;
        public int sum;
        public Node left, right;
        Node(int sum, int l, int r) {
            this.sum = sum;
            this.range = new int[]{l, r};
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {92, 53, 69, 89, 94, 48, 18, 70, 26, 34, 87};

        Node root = constructTree(nums, 0, nums.length - 1);
        System.out.println("");
        System.out.println(maxArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }

    public static Node constructTree(int[] nums, int l, int r){
        if (l > r) return null;
        else if (l == r) return new Node(nums[l], l, r);
        else {
            int mid = (l + r)/2;
            Node left = constructTree(nums, l, mid);
            Node right = constructTree(nums, mid+1, r);
            int sum = left.sum + right.sum;
            Node parent = new Node(sum, l, r);
            parent.left = left;
            parent.right = right;
            return parent;
        }
    }

    public static int maxArea(int[] hist) {
        Deque<Integer> st = new ArrayDeque<>();
        int i = 0;
        int maxArea = 0;
        int areaWithMin;
        while (i < hist.length - 1) {
            if (st.isEmpty() || hist[st.peek()] <= hist[i]) {
                st.push(i++);
            } else {
                int top = st.peek();
                st.pop();
                areaWithMin = hist[top] * ((st.isEmpty())? i : i - st.peek() - 1);
                if (maxArea < areaWithMin)
                    maxArea = areaWithMin;
            }
        }
        while (!st.isEmpty()) {
            int top = st.peek();
            st.pop();
            areaWithMin = hist[top] * ((st.isEmpty())? i : i - st.peek() - 1);
            if (maxArea < areaWithMin)
                maxArea = areaWithMin;
        }
        return maxArea;
    }
}
