package com.problems;

import com.datastructure.BinaryTree;
import com.datastructure.TNode;

import java.util.*;

/**
 * Created by bahubali.n on 06/03/19.
 */
public class BinaryTreeProblem {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addRoot(new TNode(1));
        binaryTree.addNode(new TNode(2));
        binaryTree.addNode(new TNode(3));
        binaryTree.addNode(new TNode(4));
        binaryTree.addNode(new TNode(5));
        binaryTree.addNode(new TNode(6));
        binaryTree.addNode(new TNode(7));
        binaryTree.addNode(new TNode(8));
        binaryTree.addNode(new TNode(9));
        binaryTree.addNode(new TNode(10));
        //binaryTree.traverse(binaryTree.getRoot());
        //levelOrderTraversal(binaryTree.getRoot());
        //reverseLevelOrderWithStack(binaryTree.getRoot());
        levelOrderAverage(binaryTree.getRoot());
        //int heightOfTree = binaryTree.height();
        //for (int i = heightOfTree; i >= 1; i--)
          //  reverseLevelOrderTraversal(binaryTree.getRoot(), i);

        int[] inputArray = new int[]{1, 2, 3, -1, 4, 5, 6, -1, -1, -1, -1, 7, -1, -1, 8};
        TNode root = convertArrayToBT(inputArray);
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(TNode root) {
        //QueueTemp<TNode> queue = new LinkedList<>();
        Stack<TNode> stack1 = new Stack<>();
        Stack<TNode> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                TNode node = stack1.pop();
                if (node != null) {
                    stack2.add(node.getLeftNode());
                    stack2.add(node.getRightNode());
                    System.out.println(node.getValue());
                }
            }
            while (!stack2.isEmpty()) {
                TNode node = stack2.pop();
                if (node != null) {
                    stack1.add(node.getRightNode());
                    stack1.add(node.getLeftNode());
                    System.out.println(node.getValue());
                }
            }
        }
    }

    public static void reverseLevelOrderTraversal(TNode node, int level) {
        if (node == null) {
            return;
        } else if (level == 1) {
            System.out.print(node.getValue()+" ");
        } else {
            reverseLevelOrderTraversal(node.getLeftNode(), level - 1);
            reverseLevelOrderTraversal(node.getRightNode(), level - 1);
        }
    }

    public static void reverseLevelOrderWithStack(TNode root) {
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            TNode node = queue.poll();
            if (node != null) {
                queue.add(node.getLeftNode());
                queue.add(node.getRightNode());
                stack.push(node.getValue());
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    public static void levelOrderAverage(TNode root) {
        Queue<TNode> currentDepthNodes = new LinkedList<>();
        List<Double> levelAverages = new ArrayList<>();
        currentDepthNodes.add(root);
        while (!currentDepthNodes.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<TNode> nextDepthNodes = new LinkedList<>();
            while (!currentDepthNodes.isEmpty()) {
                TNode node = currentDepthNodes.poll();
                if (node != null) {
                    level.add(node.getValue());
                    nextDepthNodes.add(node.getLeftNode());
                    nextDepthNodes.add(node.getRightNode());
                }
            }
            if (!level.isEmpty()) {
                Double average = level.stream().mapToInt(val -> val).average().orElse(0.0);
                levelAverages.add(average);
            }
            currentDepthNodes = nextDepthNodes;
        }
        levelAverages.stream().forEach(System.out::println);
    }

    public static TNode convertArrayToBT(int[] listNodes) {

        int sizeOfArray = listNodes.length;
        int index = 0;
        TNode root = new TNode(listNodes[index]);
        Deque<TNode> queue = new LinkedList<>();
        queue.add(root);
        index++;
        while (!queue.isEmpty() && index < sizeOfArray - 1) {
            TNode node = queue.pop();
            if (node != null) {
                TNode left = new TNode(listNodes[index++]);
                TNode right = new TNode(listNodes[index++]);
                if (left.getValue() > 0) {
                    node.setLeftNode(left);
                    queue.add(left);
                } else {
                    queue.add(null);
                }
                if (right.getValue() > 0) {
                    node.setRightNode(right);
                    queue.add(right);
                } else {
                    queue.add(null);
                }
            }
        }
        return root;
    }
}
