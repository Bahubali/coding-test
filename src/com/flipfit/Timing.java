package com.flipfit;

import lombok.Builder;

@Builder
public class Timing {
    private String from;
    private String to;

    public boolean compareTo(Timing o) {
        return (o.from.equals(this.from) && o.to.equals(this.to));
    }
}
