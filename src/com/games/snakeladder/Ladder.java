package com.games.snakeladder;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Ladder {
    private final Position top;
    private final Position bottom;

    public Ladder(Position top, Position bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public Position getTop() { return top; }

    public Position getBottom() { return bottom; }
}
