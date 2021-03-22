package com.fllipkart.memory;

import lombok.Builder;
import lombok.Data;

import java.util.Comparator;

@Data
@Builder
public class MemoryLocation {
    private int from;
    private int to;
    private int size;

    public int getSize() {
        return (this.to - this.from) + 1;
    }
}
