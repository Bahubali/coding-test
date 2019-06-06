package com.problems;

import com.datastructure.QueueTemp;

/**
 * Created by bahubali.n on 05/05/19.
 */
public class QueueProblem {

    public static void main(String[] args) throws Exception{
        QueueTemp queue = new QueueTemp(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Dequeued : "+queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Dequeued : "+queue.dequeue());

    }
}
