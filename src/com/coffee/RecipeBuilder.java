package com.coffee;

import lombok.Builder;
import lombok.Data;

@Data
public class RecipeBuilder {

    enum RecipeType {
        Espresso, Latte, Cappuccino
    }

    private RecipeType recipeType;
    private Recipe recipe;
    public RecipeBuilder(RecipeType type) {
        this.recipeType = type;
        this.recipe = getRecipe();
    }

    private Recipe getRecipe() {
        switch (this.recipeType) {
            case Espresso:
                this.recipe = new Cappuccino();
                this.recipe.addIngredient(new Water(1));
                this.recipe.addIngredient(new Milk(1));
                this.recipe.addIngredient(new CoffeePowder(1));
            default:
                break;

        }
        return this.recipe;
    }
}
