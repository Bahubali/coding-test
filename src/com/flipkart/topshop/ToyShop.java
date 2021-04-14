package com.flipkart.topshop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ToyShop {

    private Map<String, List<Part>> toyParts;

    ToyShop() {
        this.toyParts = new HashMap<>();
    }

    public void addToyPart(String toyId, Part part) {

    }

    public static void main(String[] args) {
        ToyShop shop = new ToyShop();

    }
}
