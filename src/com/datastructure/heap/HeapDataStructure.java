package com.datastructure.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bahubali.n on 29/05/19.
 */
public class HeapDataStructure {

    List<Integer> list = null;

    public HeapDataStructure() {
        this.list = new ArrayList<>();
        list.add(Integer.MAX_VALUE);
    }

    public void push(Integer element) throws Exception {
        if (list == null) {
            throw new Exception("List is not initialised");
        }
        this.list.add(element);
        if (list.size() > 2) {
            int lastIndex = this.list.lastIndexOf(element);
            int parentIndex = (lastIndex / 2);
            if (element > list.get(parentIndex)) adjustListFromBottom();
        }
    }

    public void adjustListFromBottom() {
        int index = list.size() - 1;
        while (index > 1) {
            int parentIndex = Math.floorDiv(index, 2);
            if (list.get(index) > list.get(parentIndex)) {
                Collections.swap(list, parentIndex, index);
            }
            index = parentIndex;
        }
    }

    public void adjustListFromTop() {
        int index = 1;
        int left = 2*index;
        int right = 2*index + 1;
        boolean swapped = true;
        while (swapped && (left <= (list.size() / 2) || right <= (list.size()/2))) {
            swapped = false;
            if (list.get(index) > list.get(left)) {
                Collections.swap(list, left, index);
                index = left;
                swapped = true;
            } else if (list.get(index) > list.get(right)) {
                Collections.swap(list, right, index);
                index = right;
                swapped = true;
            }
        }
    }

    public Integer pop() {
        Integer element = list.get(1);
        Collections.swap(list, 1, list.size()-1);
        return element;
    }

    public void sort() {
        int heapSize = list.size();
        while (heapSize >= 1) {
            Integer element = this.pop();
            System.out.println(element);
            list.remove(list.size()-1);
            adjustListFromTop();
            heapSize = list.size();
        }
    }
}
