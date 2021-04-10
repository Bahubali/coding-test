package com.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionValidator {

    public static void main(String[] args) {
        String expression = "}[{()}()]]";
        System.out.println("Is expression is balanced? "+isBalanced(expression));

        Deque<Integer> numStack = new ArrayDeque<>();
        numStack.push(1);
        numStack.push(2);
        numStack.push(3);
        numStack.push(4);
        reverseStack(numStack);
        while (!numStack.isEmpty()) {
            System.out.print(numStack.pop()+" ");
        }
        System.out.println();
        int[] nums = {4, 5, 2, 7, 3, 1, 6, 10, 25};
        nextGreaterElement(nums);
        System.out.println(expressionEval("10 * (2 + 12)"));
    }

    public static boolean isBalanced(String expr) {
        Deque<Character> stack = new ArrayDeque<Character>();
        boolean isBalanced = false;
        for (int i = 0; i < expr.length(); i++) {
            Character character = expr.charAt(i);
            if (character.equals('[') || character.equals('{') || character.equals('(')) {
                stack.add(character);
            } else {
                if (stack.isEmpty()) return false;
                Character top = stack.pop();
                switch (character) {
                    case ')':
                        isBalanced = (top.equals('('))? true : false;
                    case '}':
                        isBalanced = (top.equals('{'))? true : false;
                    case ']':
                        isBalanced = (top.equals('['))? true : false;
                    default:
                }
            }
        }
        isBalanced = (stack.isEmpty())? true : false;
        return isBalanced;
    }

    public static void reverseStack(Deque<Integer> st) {
        if (st.isEmpty()) return;
        else {
            Integer num = st.pop();
            reverseStack(st);
            st.push(num);
        }
    }

    public static void nextGreaterElement(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int element, next;
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            next = nums[i];
            if (!stack.isEmpty()) {
                element = stack.pop();
                while (element < next) {
                    System.out.println(element+" - "+next);
                    if (stack.isEmpty()) break;
                    element = stack.pop();
                }
                if (element > next)
                    stack.push(element);
            }
            stack.push(next);
        }
    }

    public static int expressionEval(String expr) {
        char[] tokens = expr.toCharArray();
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Integer> values = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') continue;
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer buffer = new StringBuffer();
                while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9')) {
                    buffer.append(tokens[i++]);
                }
                values.push(Integer.parseInt(buffer.toString()));
                i--;
            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOps(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOps(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
        }
        while (!ops.isEmpty()) {
            values.push(applyOps(ops.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }

    public static int applyOps(char ops, int a, int b) {
        switch (ops) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) System.out.println("Invalid ops");
                return a / b;
        }
        return 0;
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op1 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }
}
