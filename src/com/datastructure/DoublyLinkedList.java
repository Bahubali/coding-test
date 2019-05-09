package com.datastructure;

/**
 * Created by bahubali.n on 29/01/19.
 */
public class DoublyLinkedList<T> {

    protected int size = 0;
    protected Node<T> head;
    protected Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node<T> element = new Node<T>(data);
        if (this.head == null) {
            this.head = element;
            this.tail = element;
        } else {
            element.setPrev(this.tail);
            this.tail.setNext(element);
            this.tail = element;
        }
        size++;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setHead(Node<T> head) { this.head = head; }

    public void reverse() {
        Node<T> current = this.getHead();
        while (current != null) {
            Node<T> prev = current.getPrev();
            Node<T> next = current.getNext();
            current.setPrev(next);
            current.setNext(prev);
            if (prev == null) this.tail = current;
            if (next == null) this.head = current;
            current = next;
        }
    }

    public Node<Integer> sumSort(Node<Integer> head) {
        if (head == null) {
            return head;
        }

        if (head.getPrev() != null) {
            if (head.getKey() <= 0 && head.getPrev().getKey() > 0) {
                Node<Integer> p1 = head.getPrev();
                Node<Integer> p2 = head;
                Node<Integer> prev = p1.getPrev();
                Node<Integer> next = p2.getNext();
                if (prev != null) {
                    prev.setNext(p2);
                }
                p2.setPrev(prev);
                p2.setNext(p1);
                p1.setPrev(p2);
                p1.setNext(next);
                if (next != null) {
                    next.setPrev(p1);
                }
            }
        }
        head.setNext(sumSort(head.getNext()));
        //sumSort(head.getPrev());
        return head;
    }

    public void deleteAfterNode(int skip, int delete) {
        Node<T> current = this.getHead();
        int count = 1;
        while (count < (skip + delete)) {
            if (count < skip) current = current.getNext();
            else {
                current.setNext(current.getNext().getNext());
            }
            count++;
        }
    }

    public void print() {
        Node<T> current = this.getHead();
        while (current != null) {
            System.out.println(current.getKey());
            current = current.getNext();
        }
    }

}
