package com.datastructure.heap;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bahubali.n on 29/05/19.
 */
public class TestHeapDataStructure {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 20, 30, 40);
        HeapDataStructure heap = new HeapDataStructure();
        list.stream().forEach(num -> {
            try {
                heap.push(num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        heap.sort();
    }
}
