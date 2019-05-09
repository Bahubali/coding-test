package com.problems;

import com.datastructure.DoublyLinkedList;
import com.datastructure.Node;

/**
 * Created by bahubali.n on 18/02/19.
 */
public class DoublyLinkedListProblem {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(9);
        doublyLinkedList.add(7);
        doublyLinkedList.add(3);
        doublyLinkedList.add(2);
        doublyLinkedList.add(5);
        doublyLinkedList.add(1);
        doublyLinkedList.add(4);
        doublyLinkedList.add(6);
        doublyLinkedList.add(10);
        DoublyLinkedListProblem.quickSort(doublyLinkedList.getHead(), doublyLinkedList.getTail());
        doublyLinkedList.print();
    }

    public static Node<Integer> partition(Node<Integer> low, Node<Integer> high) {
        Integer pivotElement = high.getKey();
        Node<Integer> pointer1 = low.getPrev();

        for (Node<Integer> pointer2 = low; pointer2 != high; pointer2 = pointer2.getNext()) {
            if (pointer2.getKey() <= pivotElement) {
                pointer1 = (pointer1 == null)? low : pointer1.getNext();
                Integer temp = pointer2.getKey();
                pointer2.setKey(pointer1.getKey());
                pointer1.setKey(temp);
            }
        }
        pointer1 = (pointer1 == null)? low : pointer1.getNext();
        Integer temp = high.getKey();
        high.setKey(pointer1.getKey());
        pointer1.setKey(temp);

        return pointer1;

    }

    public static void quickSort(Node<Integer> l, Node<Integer> r) {
        if (r != null && l != r && l != r.getNext()) {
            Node<Integer> pivot = partition(l, r);
            quickSort(l, pivot.getPrev());
            quickSort(pivot.getNext(), r);
        }
    }


}
