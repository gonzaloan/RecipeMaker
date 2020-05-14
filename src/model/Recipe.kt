package model

import interfaces.Cook

class Recipe : Cook {
    private var ingredients: MutableList<Ingredient> = mutableListOf()

    override fun add(ingredient: Ingredient) {

        ingredients.add(ingredient)
    }

    override fun remove(recipeId: Int) {
        ingredients.removeAt(recipeId)

    }

    fun getIngredients(): MutableList<Ingredient> {
        return ingredients
    }

    override fun toString(): String {
        var ingredientsList = ""
        ingredients.forEach { element ->
            ingredientsList = ingredientsList.plus("Ingrediente: ${element.name} Cantidad: ${element.quantity}\n")
        }
        return ingredientsList
    }


}