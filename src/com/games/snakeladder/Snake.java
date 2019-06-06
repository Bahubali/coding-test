package com.games.snakeladder;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Snake {
    private final Position head;
    private final Position tail;

    public Snake(Position head, Position tail) {
        this.head = head;
        this.tail = tail;
    }

    public Position getHead() {
        return head;
    }

    public Position getTail() {
        return tail;
    }
}
