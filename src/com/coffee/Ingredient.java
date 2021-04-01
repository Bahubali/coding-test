package com.coffee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Ingredient {

    private int parts;
    private String name;

    Ingredient(int parts) {
        this.parts = parts;
    }
}
