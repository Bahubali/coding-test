package com.coffee;
import java.util.ArrayList;
import java.util.List;

public abstract class Recipe {

    private List<Ingredient> ingredientList;

    Recipe() {
        this.ingredientList = new ArrayList<Ingredient>();
    }
    protected void addIngredient(Ingredient ingredient) {
        this.ingredientList.add(ingredient);
    }
}
