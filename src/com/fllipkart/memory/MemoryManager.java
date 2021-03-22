package com.fllipkart.memory;

import java.io.BufferedReader;
import java.util.*;
public class MemoryManager {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        //int memoryBlocks = Integer.parseInt(scanner.next().trim());
        Process p1 = new Process("P1");
        Process p2 = new Process("P2");
        String var = "var_x";
        Memory memory = new Memory(100);
        p1.assignMemory(var, memory.allocate(10, true));
        p2.assignMemory("var_y", memory.allocate(25, true));
        memory.reclaimMemory(p1.freeMemory("var_x"));
        p2.assignMemory("var_z", memory.allocate(15, false));
        memory.status();
    }
}
