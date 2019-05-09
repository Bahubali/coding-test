package com.problems;

import com.datastructure.BinaryTree;
import com.datastructure.TNode;

/**
 * Created by bahubali.n on 05/05/19.
 */
public class HeightBalancedTree {

    private boolean balanced;
    private int height;

    public HeightBalancedTree(int height, boolean isBalanced) {
        this.balanced = isBalanced;
        this.height = height;
    }

    public static boolean isBalancedTree(TNode root) {
        return checkBalanced(root).balanced;
    }

    private static HeightBalancedTree checkBalanced(TNode node) {
        if (node == null) {
            return new HeightBalancedTree(-1, true);
        }

        HeightBalancedTree leftSubTree = checkBalanced(node.getLeftNode());
        if (!leftSubTree.balanced) {
            return leftSubTree;
        }
        HeightBalancedTree rightSubTree = checkBalanced(node.getLeftNode());
        if (!rightSubTree.balanced) {
            return rightSubTree;
        }

        boolean isBalanced = Math.abs(leftSubTree.height - rightSubTree.height) <= 1;
        int height = Math.max(leftSubTree.height, rightSubTree.height) + 1;
        return new HeightBalancedTree(height, isBalanced);
    }

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

        System.out.println("Balanced?"+HeightBalancedTree.isBalancedTree(binaryTree.getRoot()));
    }
}
