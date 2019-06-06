package com.datastructure;

/**
 * Created by bahubali.n on 05/05/19.
 */
public class QueueTemp {

    private int head = 0, tail = 0, numQueueElements = 0;
    private Integer[] entries;

    public QueueTemp(int capacity) {
        entries = new Integer[capacity];
    }

    public void enqueue(int val) {
        if (numQueueElements < entries.length) {
            entries[tail] = val;
            tail = (tail + 1) % entries.length;
            ++numQueueElements;
        }
    }

    public Integer dequeue() throws Exception {
        if (numQueueElements > 0) {
            --numQueueElements;
            Integer result = entries[head];
            head = (head + 1) % entries.length;
            return result;
        }
        throw new Exception("No element exist in queue");
    }
}
