package com.games.snakeladder;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Ladder {
    private final Panel top;
    private final Panel bottom;

    public Ladder(Panel top, Panel bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public Panel getTop() { return this.top; }

    public Panel getBottom() { return this.bottom; }
}
