package com.datastructure.graphs;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayDeque;
import java.util.Deque;

public class Graph {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.addEdge(2);
        node.addEdge(6);
        node.addEdge(0);
        node.getEdge(2).addEdge(9);
        node.getEdge(2).addEdge(4);
        node.getEdge(2).addEdge(3);
        node.getEdge(2).getEdge(4).addEdge(5);
        node.getEdge(6).addEdge(7);
        node.getEdge(6).addEdge(8);

        System.out.println("BFS of graph");
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.getKey()+" ");
            current.getEdges().stream().forEach(n -> { queue.add(n);});
        }
        System.out.println();
        System.out.println("DFS of graph");
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.getKey()+" ");
            if (!current.getEdges().isEmpty())
                current.getEdges().stream().forEach(n -> { stack.push(n);});
        }
    }
}
