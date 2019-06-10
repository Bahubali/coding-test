package com.games.snakeladder;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Snake {
    private final Panel headIn;
    private final Panel tailIn;

    public Snake(Panel head, Panel tail) throws Exception {
        this.headIn = head;
        head.addSnake(this);
        this.tailIn = tail;
    }

    public Panel getHeadIn() {
        return this.headIn;
    }

    public Panel getTailIn() {
        return this.tailIn;
    }
}
