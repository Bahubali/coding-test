package com.problems;

import java.util.*;

public class MergeIntervals {
    static class Intervals {
        public int start, end;
        Intervals(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {
        Intervals[] intervals = new Intervals[]{
                new Intervals(1, 3),
                new Intervals(3, 7),
                new Intervals(2, 4),
                new Intervals(6, 8)
        };
        Arrays.sort(intervals, new Comparator<Intervals>() {
            public int compare(Intervals i1, Intervals i2) {
                return i1.start - i2.start;
            }
        });
        Deque<Intervals> st = new ArrayDeque<>();
        st.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Intervals top = st.peek();
            if (top.end < intervals[i].start){
                st.push(intervals[i]);
            } else if (top.end > intervals[i].start) {
                top.end = intervals[i].end;
                st.pop();
                st.push(top);
            }
        }
        while (!st.isEmpty()) {
            Intervals it = st.pop();
            System.out.println(it.start +" - "+it.end);
        }

        //System.out.println(infixToPostfix("a+b(c^d-e)"));
        int[] nums = {4, 1, 5, 7, 8, 2};
        insertionSort(nums);
        Arrays.stream(nums).forEach(num -> System.out.print(num+" "));
    }

    public static String infixToPostfix(String expr) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < expr.length(); i++) {
            Character c = expr.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                buffer.append(c);
            }
            else if (c.equals('(')) {
                stack.push(c);
            }
            else if (c.equals(')')) {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    buffer.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    buffer.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            buffer.append(stack.pop());
        }
        return buffer.toString();
    }

    public static int precedence(Character operator) {
        switch (operator){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void insertionSort(int[] nums) {
        int i, j;
        for (i = 0; i < nums.length; i++) {
            j = i;
            while (j > 0 && nums[j-1] > nums[j]) {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j = j-1;
            }
        }
    }
}
