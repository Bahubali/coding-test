package com.problems;

import com.datastructure.BinaryTree;
import com.datastructure.TNode;
import com.google.common.collect.BiMap;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class TreeAlgo {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(new TNode(1));
        tree.addNode(new TNode(2));
        tree.addNode(new TNode(3));
        tree.addNode(new TNode(4));
        tree.addNode(new TNode(5));
        tree.addNode(new TNode(6));
        tree.addNode(new TNode(7));
        tree.addNode(new TNode(8));

        findAncestors(tree.getRoot(), 7);
    }

    public static void findAncestors(TNode root, int key) {
        Deque<TNode> st = new ArrayDeque<>();
        while (true) {
            while (root != null && root.value != key) {
                st.push(root);
                root = root.getLeftNode();
            }
        }
    }
}
