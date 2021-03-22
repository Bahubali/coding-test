package com.fllipkart.memory;

import java.util.Comparator;

public class MemoryComparator implements Comparator<MemoryLocation> {

    @Override
    public int compare(MemoryLocation o1, MemoryLocation o2) {
        return (o1.getFrom() > o2.getFrom())? 0 : 1;
    }
}
