package com.flipkart.topshop;

import java.util.ArrayList;
import java.util.List;

public class Toy {
    private String name;
    private List<Part> parts;
    Toy(String name) {
        this.name = name;
        this.parts = new ArrayList<>();
    }

    public void addPart(Part part) {
        if (this.parts != null)
            this.parts.add(part);
    }
}
