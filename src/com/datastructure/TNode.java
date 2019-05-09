package com.datastructure;

/**
 * Created by bahubali.n on 25/02/19.
 */
public class TNode {

    public Integer value;
    TNode leftNode;
    TNode rightNode;

    public TNode(Integer val) {
        this.setValue(val);
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int val){
        this.value = val;
    }

    public TNode getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(TNode node) {
        this.leftNode = node;
    }

    public TNode getRightNode() {
        return this.rightNode;
    }

    public void setRightNode(TNode node) {
        this.rightNode = node;
    }
}
