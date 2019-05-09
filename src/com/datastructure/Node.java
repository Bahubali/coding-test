package com.datastructure;

/**
 * Created by bahubali.n on 28/01/19.
 */
public class Node<T> {
    protected T key;
    protected Node<T> next;
    protected Node<T> prev;

    public Node(T data) {
        this.key = data;
        this.next = null;
        this.prev = null;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public T getKey() {
        return this.key;
    }
    public void setKey(T data) {
         this.key = data;
    }


}
