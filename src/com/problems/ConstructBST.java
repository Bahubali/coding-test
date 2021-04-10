package com.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructBST {


    public static void main(String[] args) {
        int[] nums = {10, 5, 1, 7, 40, 50};
        Node root = new Node(nums[0]);
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        for (int i = 1; i < nums.length; i++) {
            Node node = null;
            while (!stack.isEmpty() && stack.peek().key < nums[i]) {
                node = stack.pop();
            }
            if (node != null && node.right == null) {
                node.right = new Node(nums[i]);
                stack.push(node.right);
            } else {
                node = stack.peek();
                if (node.left == null) {
                    node.left = new Node(nums[i]);
                    stack.push(node.left);
                }
            }
        }
        postOrder(root);
    }

    public static void preOrder(Node node) {
        if (node == null) return;
        else {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static  void postOrder(Node node) {
        Deque<Node> stack1 = new ArrayDeque<>();
        Deque<Node> stack2 = new ArrayDeque<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            Node temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) stack1.push(temp.left);
            if (temp.right != null) stack1.push(temp.right);
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().key+" ");
        }
    }
}

class Node {
    public int key;
    public Node left, right;
    Node(int k) {
        this.key = k;
        this.left = null;
        this.right = null;
    }
}
