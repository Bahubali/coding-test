package com.datastructure;

import java.util.NoSuchElementException;

/**
 * Created by bahubali.n on 28/01/19.
 */
public class LinkedList<T> {

    protected int size = 0;
    protected Node<T> head;
    protected Node<T> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node<T> element = new Node<T>(data);
        if (this.head == null) {
            this.head = element;
            this.tail = element;
        } else {
            this.tail.setNext(element);
            this.tail = element;
        }
        size++;
    }

    public void add(Node<T> next) {
        if (this.head == null) {
            this.head = next;
            this.tail = next;
        } else {
            this.tail.setNext(next);
            this.tail = next;
        }
        size++;
    }

    public void addAfter(T after, T data) {
        Node<T> elementFound = search(after);
        if (elementFound == null) {
            throw new NoSuchElementException("Element \""+after+ "\" not found");
        }
        Node<T> tobeAdded = new Node(data);
        Node<T> temp = elementFound.getNext();
        elementFound.setNext(tobeAdded);
        tobeAdded.setNext(temp);
        size++;
    }

    public Node<T> search(T key) {
        Node<T> list = this.head;
        boolean isExist = false;
        while (list.getNext() != null) {
            if (list.key == key) {
                isExist = true;
                break;
            }
            list = list.getNext();
        }
        return (isExist)? list : null;
    }

    /**
     * Pop last item from list - in stack way
     *
     * @return
     */
    public T pop() {
        Node<T> current = this.getHead();
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        T data = current.getNext().getKey();
        current.setNext(null);
        this.tail = current;
        return data;
    }

    public void removeDup() {
        Node<T> current = this.getHead();
        while(current != null && current.getNext() != null) {
            if (current.getKey() == current.getNext().getKey()) {
                Node<T> temp = current.getNext().getNext();
                current.setNext(temp);
            } else {
                current = current.getNext();
            }
        }
    }

    public void deleteAlt() {

        Node<T> currentNode = this.getHead().getNext();
        Node<T> prevNode = this.getHead();
        while (prevNode != null && currentNode != null) {
            prevNode.setNext(currentNode.getNext());
            prevNode = prevNode.getNext();
            if (prevNode != null)
                currentNode = prevNode.getNext();
        }
    }

    public void merge(LinkedList<T> newList) {
        Node<Integer> l1 = (Node<Integer>) this.getHead();
        Node<Integer> l2 = (Node<Integer>) newList.getHead();
        while (l1 != null && l2 != null) {
            if (l1.getKey() < l2.getKey()) {
                if (l1.getNext().getKey() > l2.getKey()) {
                    Node<Integer> temp = new Node<>(l2.getKey());
                    temp.setNext(l1.getNext());
                    l1.setNext(temp);
                    l2 = l2.getNext();
                }
                l1 = l1.getNext();
            } else if (l1.getKey() > l2.getKey()) {
                Node<Integer> temp = new Node<>(l2.getKey());
                temp.setNext(l1);
                this.setHead((Node<T>) temp);
                l1 = temp;
                l2 = l2.getNext();
            }
        }
    }


    public Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> mid = findMidNode(head);
        Node<Integer> nextToMid = mid.getNext();
        mid.setNext(null);

        Node<Integer> left = mergeSort(head);
        Node<Integer> right = mergeSort(nextToMid);

        Node<Integer> sortedList = merge(left, right);
        return sortedList;
    }

    private Node<Integer> findMidNode(Node<Integer> head) {
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

    private Node<Integer> merge(Node<Integer> left, Node<Integer> right) {
        Node<Integer> result = null;
        if (left == null) return right;
        if (right == null) return left;

        if (left.getKey() < right.getKey()) {
            result = left;
            result.setNext(merge(left.getNext(), right));
        } else {
            result = right;
            result.setNext(merge(left, right.getNext()));
        }
        return result;
    }

    public Node<T> reverse(Node<T> head, int k) {
        Node<T> current = head;
        Node<T> next = null;
        Node<T> prev = null;
        int count = 0;
        while (current != null && count < k) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.setNext(reverse(next, k));

        return prev;
    }

    public void reverse(Node<Integer> head, Node<Integer> prev) {
        if (head == null) {
            return;
        } else {
            if (prev != null) {
                if (prev.getKey() < head.getKey()) {
                    Node<Integer> next = head.getNext();
                    prev.setNext(head.getNext());
                    head.setNext(prev);
                    reverse(head.getNext(), head);
                }
            }
            reverse(head.getNext(), head);
        }
    }

    public void deleteLesserNode() {
        Node<Integer> current = (Node<Integer>) this.getHead();

        while (current != null && current.getNext() != null) {
            Node<Integer> temp = current.getNext();
            if (current.getKey() < temp.getKey()) {
                current.setKey(temp.getKey());
                current.setNext(temp.getNext());
            } else {
                current = current.getNext();
            }
        }
    }

    public Node<Integer> seggregateEvenOdd(Node<Integer> current, Node<Integer> prev) {
        Node<Integer> end = null;
        if (current == null) {
            return prev;
        } else {
            if (prev == null) {
                if (current.getKey() % 2 != 0) {
                    Integer temp = current.getKey();
                    current.setKey(current.getNext().getKey());
                    current.getNext().setKey(temp);
                }
            }
            end = seggregateEvenOdd(current.getNext(), current);
            if (prev != null && current.getNext() != null) {
                if (current.getKey() % 2 != 0) {
                    prev.setNext(current.getNext());
                    current.setNext(null);
                    end.setNext(current);
                    end = end.getNext();
                }
            }
        }
        return end;
    }

    public void detachLoop() {
        Node<T> slowPtr = this.getHead();
        Node<T> fastPtr = slowPtr.getNext();
        Node<T> endPtr = null;

        while (slowPtr != fastPtr) {
            fastPtr = fastPtr.getNext();
            if (fastPtr != null) {
                slowPtr = slowPtr.getNext();
                fastPtr = fastPtr.getNext();
                endPtr = fastPtr;
            }
        }
        endPtr.getNext().setNext(null);
    }

    public TNode convertToBST(int n) {
        if (n <= 0) return null;


        TNode left = convertToBST(n/2);
        TNode root = new TNode((Integer) head.getKey());
        root.setLeftNode(left);

        head = head.getNext();

        TNode right = convertToBST(n - n/2 - 1);
        root.setRightNode(right);

        return root;
    }

    public void rotateList(int k) {
        int count = 0;

        while (count < k && head != null) {
            Node<T> temp = head;
            head = head.getNext();
            temp.setNext(null);
            add(temp);
            count++;
        }
    }

    public Node<T> removeFirst() {
        if (head != null) {
            head = head.getNext();
        }
        return head;
    }

    public void print() {
        Node<T> current = getHead();
        while (current != null) {
            System.out.println(current.getKey());
            current = current.getNext();
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int size() {
        return this.size;
    }
}
