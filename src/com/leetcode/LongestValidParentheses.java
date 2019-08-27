package com.leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        String inputStr = ")()())";
        System.out.println("Longest parenthesis:"+findValidParentheses(inputStr));
    }

    public static int findValidParentheses(String inputStr) {
        if (inputStr.isEmpty()) return 0;
        char[] parentheses = inputStr.toCharArray();
        Stack<Integer> numStack = new Stack<Integer>();
        numStack.push(-1);
        int longestParentheses = 0;
        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i] == '(') {
                numStack.push(i);
            } else {
                numStack.pop();
                if (!numStack.empty())
                    longestParentheses = Math.max(longestParentheses, (i - numStack.peek()));
                else numStack.push(i);
            }
        }
        return longestParentheses;
    }
}
