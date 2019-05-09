package com.problems;

import com.datastructure.LinkedList;
import com.datastructure.Node;
import com.datastructure.TNode;

import java.util.HashSet;

/**
 * Created by bahubali.n on 28/01/19.
 */
public class LinkedListProblem {
    static Node<Character> left;
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(7);
        list.add(17);
        list.add(13);
        list.add(11);
        list.add(23);
        list.add(25);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(12);
        list2.add(10);
        list2.add(2);
        list2.add(4);
        list2.add(6);
        //list2.add(21);

        Node<Integer> l1 = list.getHead();
        Node<Integer> l2 = list2.getHead();
        while (l2 != null && l1 != null) {
            Node<Integer> temp = l1.getNext();
            Node<Integer> mid = new Node<>(l2.getKey());
            mid.setNext(temp);
            l1.setNext(mid);
            l1 = l1.getNext().getNext();
            //System.out.println(l2.getKey());
            l2 = list2.removeFirst();
        }
        while (l2 != null) {
            list.add(l2);
            l2 = list2.removeFirst();
        }
        list.print();

//        TNode bst = list.convertToBST(list.size());
//        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        binarySearchTree.setRoot(bst);
//        binarySearchTree.traverse(bst);
        System.out.println("BST conversion done");

        //LinkedList<Integer> node2 = new LinkedList<>();
//        node1.add(10);
//        node1.add(5);
//        node1.add(6);
//        node1.add(1);

//        node1.setHead(node1.mergeSort(node1.getHead()));
//        node1.print();
        //Node<Integer> last = new Node<Integer>(90);
        //last.setNext(test.getHead().getNext().getNext().getNext().getNext().getNext());
        //test.add(last);
        //reverseList(test, test.getHead());
        //reverseList(test, test.getHead());

//        System.out.println("Last element in list: "+test.pop());
//        System.out.println("Last element in list: "+test.pop());
//        System.out.println("Last element in list: "+test.pop());
//        System.out.println("Last element in list: "+test.pop());
//        System.out.println("Last element in list: "+test.pop());
        //node1.deleteAlt();
        //Node<Integer> current = result.getHead();
//        node1.print();
//        node1.deleteAlt();
//        node1.print();

    }

    public static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Node<Integer> pointer1 = list1.getHead();
        Node<Integer> pointer2 = list2.getHead();
        LinkedList<Integer> current = new LinkedList<>();
        while (pointer1 != null &&  pointer2 != null) {
            if (pointer1.getKey() <= pointer2.getKey()) {
                current.add(pointer1.getKey());
                pointer1 = pointer1.getNext();
            } else {
                current.add(pointer2.getKey());
                pointer2 = pointer2.getNext();
            }
        }
        current.add((pointer1 != null)? pointer1.getKey() : pointer2.getKey());
        return current;
    }

    public static void reverseList(LinkedList<Integer> list, Node<Integer> head) {
        if (head.getNext() == null) {
            // base case
            list.setHead(null);
            list.add(head.getKey());
        } else {
            Node<Integer> current = head;
            reverseList(list, head.getNext());
            list.add(current.getKey());
        }
    }

    public static boolean isLoopExist(LinkedList<Integer> list) {
        Node<Integer> p1 = list.getHead();
        Node<Integer> p2 = list.getHead();
        while (p1 != null && p2 != null && (p2.getNext() != null)) {
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public static Node<Character> isPalindrome(Node<Character> slow, Node<Character> fast) {
        if (fast.getNext() == null) {
            return null;
        } else if (fast == null) {
            return null;
        } else {
            Node<Character> prev = null;
            if (fast.getNext() != null) {
                prev = slow;
                slow = slow.getNext();
                fast = fast.getNext().getNext();
            }
            Node<Character> next = isPalindrome(slow, fast);
            if (next != null) {
                System.out.println("Prev : " + prev.getKey());
                System.out.println("Next : " + next.getKey());
                slow = slow.getNext();
            }
            return slow;
        }
    }

    public static void reversePrint(Node<Integer> head) {
        if (head.getNext() == null) {
            System.out.println(head.getKey());
        } else {
            Node<Integer> current = head;
            reversePrint(head.getNext());
            System.out.println(current.getKey());
        }
    }

    public static void removeDuplicatesFromList(Node<Integer> head) {
        HashSet<Integer> hashSet = new HashSet<>();

        Node<Integer> current = head;
        Node<Integer> prev = null;
        while (current != null) {
            if (hashSet.contains(current.getKey())) {
                prev.setNext(current.getNext());
            } else {
                hashSet.add(current.getKey());
                prev = current;
            }
            current = current.getNext();
        }
    }

    public static void splitCircularList(Node<Integer> head) {
        Node<Integer> pointer1 = head;
        Node<Integer> pointer2 = head;

        int loopCount = 0;
        while (pointer1 != null && pointer2 != null && (pointer2.getNext() != null)) {
            if (pointer1.getKey() == pointer2.getKey()) {

            }
            pointer1 = pointer1.getNext();
            pointer2 = pointer1.getNext().getNext();
            loopCount++;
        }
    }


    public static void test1(Node<Integer> head) {
        if (head == null) return;

        test1(head.getNext());
        System.out.println(head.getKey());
    }

    public static void test2(Node<Integer> head) {
        if (head == null) return;

        System.out.println(head.getKey());
        if (head.getNext() != null)
            test2(head.getNext().getNext());
        System.out.println(head.getKey());
    }

    public static LinkedList<Integer> sortedIntersect(Node<Integer> node1, Node<Integer> node2) {

        LinkedList<Integer> result = new LinkedList<>();
        while (node1 != null && node2 != null) {
            if (node1.getKey() == node2.getKey()) {
                result.add(node1.getKey());
                node1 = node1.getNext();
                node2 = node2.getNext();
            } else if (node1.getKey() < node2.getKey()) {
                node1 = node1.getNext();
            } else {
                node2 = node2.getNext();
            }
        }

        return result;
    }


    public static TNode convertToBST(Node<Integer> head, int n) {
        if (n <= 0) return null;


        TNode left = convertToBST(head, n/2);
        TNode root = new TNode(head.getKey());
        if (left != null) root.setLeftNode(left);

        head = head.getNext();

        TNode right = convertToBST(head, n - n/2 - 1);
        if (right != null) root.setRightNode(right);

        return root;
    }

    public static Node<Integer> findMidNode(Node<Integer> head) {
        Node<Integer> fastPtr = head.getNext();
        Node<Integer> slowPtr = head;

        while (fastPtr != null) {
            fastPtr = fastPtr.getNext();
            if (fastPtr != null) {
                slowPtr = slowPtr.getNext();
                fastPtr = fastPtr.getNext();
            }
        }
        return slowPtr;
    }

    public static void mergeAlternatively(Node<Integer> l1, Node<Integer> l2) {

    }


}
