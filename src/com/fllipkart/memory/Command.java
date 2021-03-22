package com.fllipkart.memory;

import lombok.Builder;
import lombok.Data;

import java.util.*;

@Data
@Builder
public class Command {

    private Type type;
    private Process process;
    private Memory memory;
    private int size;
    private boolean continuous;
    private String var;
    enum Type {
        ALLOCATE, FREE, KILL;
    }

    public void execute() {
        switch (type) {
            case ALLOCATE: allocate();
                break;
            default:
        }
    }

    private void allocate() {
        List<MemoryLocation> allocated = memory.allocate(this.size, this.continuous);
        this.process.assignMemory(this.var, allocated);
    }
}
