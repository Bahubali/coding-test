/* package codechef; // don't place package name! */

import java.util.*;
import java.util.Queue;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class BinarySearchTree {
    private BinaryTreeNode root;

    BinarySearchTree() { root = null; }

    public void addNode(BinaryTreeNode newNode) {
        if(root == null) root = newNode;
        else {
            append(root, newNode);
        }
    }

    private void append(BinaryTreeNode root, BinaryTreeNode newNode) {
        if (root.data < newNode.data) {
            if (root.left == null) root.left = newNode;
            else append(root.left, newNode);
        } else {
            if (root.right == null) root.right = newNode;
            else append(root.right, newNode);
        }
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public int heightOfTree() {
        return findHeight(root);
    }

    public void getLeafNodes(ArrayList<Integer> list) {
        getNodesAtLevel(root, heightOfTree(), list);
    }

    private void getNodesAtLevel(BinaryTreeNode node, int level, ArrayList<Integer> list) {
        if (node == null) return;
        else if (level == 1) {
            list.add(node.data);
        } else {
            getNodesAtLevel(node.left, level - 1, list);
            getNodesAtLevel(node.right, level - 1, list);
        }
    }

    private int findHeight(BinaryTreeNode node) {
        if (node == null) return 0;
        else {
            int lHeight = findHeight(node.left);
            int rHeight = findHeight(node.right);
            return 1 + Math.max(lHeight, rHeight);
        }
    }

    public static void main (String[] args) {

        /* code */
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.addNode(new BinaryTreeNode(8));
        binaryTree.addNode(new BinaryTreeNode(10));
        binaryTree.addNode(new BinaryTreeNode(3));
        binaryTree.addNode(new BinaryTreeNode(1));
        binaryTree.addNode(new BinaryTreeNode(6));
        binaryTree.addNode(new BinaryTreeNode(14));

        ArrayList<Integer> leafNodes = new ArrayList();
        binaryTree.getLeafNodes(leafNodes);
        leafNodes.stream().forEach(System.out::println);

        // BinaryTreeNode root = binaryTree.getRoot();
        // Queue<BinaryTreeNode> queue = new LinkedList<>();
        // queue.add(root);
        // while(!queue.isEmpty()) {
        //     BinaryTreeNode node = queue.poll();
        //     if (node != null) {
        //         queue.add(node.left);
        //         queue.add(node.right);
        //         System.out.println(node.data);
        //     }
        // }
    }
}
class BinaryTreeNode
{
    public Integer data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(Integer val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
