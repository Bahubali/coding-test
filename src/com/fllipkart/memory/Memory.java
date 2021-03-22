package com.fllipkart.memory;

import com.google.inject.internal.asm.$ClassTooLargeException;

import java.util.*;

public class Memory {

    private int[] memoryBlocks;
    private int allocated;
    private int available;
    private int freePointer;
    Memory(int blocks) {
        this.memoryBlocks = new int[blocks];
        for (int i = 0; i < blocks - 1; i++)
            this.memoryBlocks[i] = i + 1;
        this.available = blocks;
        this.allocated = 0;
        this.freePointer = 0;
    }

    public List<MemoryLocation> allocate(int size, boolean continuous) {
        if (size > available) throw new RuntimeException("Memory not available");
        List<MemoryLocation> allocatedMemory = new ArrayList<>();
        if (continuous) {
            int start = this.freePointer;
            int end = this.freePointer;
            while (size-- > 0) {
                this.memoryBlocks[end++] = -1;
            }
            allocatedMemory.add(MemoryLocation.builder().from(start).to(end-1).build());
            this.freePointer = end;
        } else {
            int start = this.freePointer;
            while (size-- > 0) {
                int end = this.memoryBlocks[this.freePointer];
                if (Math.abs(this.freePointer - end) != 1) {
                    allocatedMemory.add(MemoryLocation.builder().from(start).to(this.freePointer).build());
                    start = end;
                }
                this.memoryBlocks[this.freePointer] = -1;
                this.freePointer = end;
            }
            int end = this.freePointer == -1 ? allocated - 1 : this.freePointer - 1;
            if (start != this.freePointer)
                allocatedMemory.add(MemoryLocation.builder().from(start).to(end).build());
        }
        int total = allocatedMemory.stream().mapToInt(l -> l.getSize()).sum();
        available = available - total;
        allocated = allocated + total;
        return allocatedMemory;
    }

    public void reclaimMemory(List<MemoryLocation> free) {
        for (MemoryLocation location: free) {
            for (int i = location.getFrom(); i < location.getTo(); i++) {
                this.memoryBlocks[i] = i + 1;
            }
            this.memoryBlocks[location.getTo()] = this.freePointer;
            this.freePointer = Math.min(location.getFrom(), this.freePointer);
            this.available += location.getSize();
            this.allocated -= location.getSize();
        }
    }

    public void status() {
        System.out.println("Memory status: "+this.allocated +"/"+this.available);
    }
}
