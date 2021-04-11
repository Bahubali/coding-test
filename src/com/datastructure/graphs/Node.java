package com.datastructure.graphs;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Node {
    private int key;
    private List<Node> edges;

    Node(int v) {
        this.key = v;
        this.edges = new LinkedList<>();
    }

    public void addEdge(int i) {
        if (edges != null) {
            this.edges.add(new Node(i));
        }
    }

    public Node getEdge(int i) {
        for (Node edge: edges) {
            if (edge.getKey() == i) return edge;
        }
        return null;
    }
}
