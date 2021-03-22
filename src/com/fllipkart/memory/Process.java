package com.fllipkart.memory;

import java.util.HashMap;
import java.util.List;

public class Process {

    private String id;
    private HashMap<String, List<MemoryLocation>> memoryMap;

    Process(String id) {
        this.id = id;
        this.memoryMap = new HashMap<>();
    }

    public void assignMemory(String var, List<MemoryLocation> memoryLocations) {
        if (this.memoryMap.containsKey(var)) {
            this.memoryMap.get(var).addAll(memoryLocations);
        } else {
            this.memoryMap.put(var, memoryLocations);
        }
    }

    public List<MemoryLocation> freeMemory(String var) {
        if (!this.memoryMap.containsKey(var)) {
            throw new RuntimeException("Invalid process variable");
        }
        List<MemoryLocation> free = this.memoryMap.get(var);
        this.memoryMap.remove(var);
        return free;
    }

}
