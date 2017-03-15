import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 28/12/16.
 */
public class TreeNode {

    public int key;
    public int value;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int k, int val) {
        this.setKey(k);
        this.setValue(val);
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int data){
        this.key = data;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int val){
        this.value = val;
    }

    public TreeNode getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(TreeNode node) {
        this.leftNode = node;
    }

    public TreeNode getRightNode() {
        return this.rightNode;
    }

    public void setRightNode(TreeNode node) {
        this.rightNode = node;
    }
}
