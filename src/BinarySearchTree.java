import sun.tools.java.BinaryMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 27/12/16.
 */
public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }


    public void addNode(int key, int val) {
        TreeNode node = new TreeNode(key, val);
        if (root == null) root = node;
        else append(root, node);

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

    public void traverse(TreeNode root) {
        if (root.getLeftNode() != null)
            traverse(root.getLeftNode());
        System.out.println(root.getValue());
        if (root.getRightNode() != null)
            traverse(root.getRightNode());
    }

    public TreeNode getRoot() {
        return this.root;
    }
}
