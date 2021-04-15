package com.flipkart.cube;

public enum Degree {
    P90(1), P180(2), N90(-1), N180(-2);

    private int val;
    Degree(int val) {
        this.val = val;
    }

    public int getVal() { return this.val; }
}
