package com.datastructure;

/**
 * Created by bahubali.n on 27/12/16.
 */
public class BinarySearchTree {

    TNode root;

    public BinarySearchTree() {
        root = null;
    }


    public void addNode(int val) {
        TNode node = new TNode(val);
        if (root == null) root = node;
        //else append(root, node);

    }

    public void append(TreeNode rootNode, TreeNode newNode) {
        int key = rootNode.getKey();
        if (key == newNode.getKey())
            rootNode.setValue(newNode.getValue());
        else if (newNode.getKey() <= key){
            if (rootNode.getLeftNode() != null)
                append(rootNode.getLeftNode(), newNode);
            else
                rootNode.setLeftNode(newNode);
        } else {
            if (rootNode.getRightNode() != null)
                append(rootNode.getRightNode(), newNode);
            else
                rootNode.setRightNode(newNode);
        }
    }

    public void traverse(TNode root) {
        if (root.getLeftNode() != null)
            traverse(root.getLeftNode());
        System.out.println(root.getValue());
        if (root.getRightNode() != null)
            traverse(root.getRightNode());
    }

    public TNode getRoot() {
        return this.root;
    }
    public void setRoot(TNode node) { this.root = node; }
}
