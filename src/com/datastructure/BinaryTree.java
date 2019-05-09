package com.datastructure;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by bahubali.n on 06/03/19.
 */
public class BinaryTree {

    protected TNode root;

    public void BinaryTree() {
        this.root = null;
    }

    public void addRoot(TNode root) {
        this.root = root;
    }

    public TNode getRoot() {
        return this.root;
    }

    public void addNode(TNode treeNode) {
        TNode head = this.root;
        add(head, treeNode);
    }

    boolean add(TNode head, TNode newNode) {
        boolean nodeAdded = false;
        Queue<TNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty() && !nodeAdded) {
            TNode node = queue.poll();
            if (node.getLeftNode() == null) {
                node.setLeftNode(newNode);
                nodeAdded = true;
            } else if (node.getRightNode() == null) {
                node.setRightNode(newNode);
                nodeAdded = true;
            }
            if (!nodeAdded) {
                if (node.getLeftNode() != null)
                    queue.add(node.getLeftNode());
                if (node.getRightNode() != null)
                    queue.add(node.getRightNode());
            }
        }
        return nodeAdded;
    }


    public int height() {
        return findHeight(this.root);
    }
    private int findHeight(TNode node) {
        if (node == null) {
            return 0;
        } else {
            int lHeight = findHeight(node.getLeftNode());
            int rHeight = findHeight(node.getRightNode());

            return 1 + Math.max(lHeight, rHeight);
        }
    }

    public void traverse(TNode root) {
        if (root.getLeftNode() != null)
            traverse(root.getLeftNode());
        System.out.println(root.getValue());
        if (root.getRightNode() != null)
            traverse(root.getRightNode());
    }
}
