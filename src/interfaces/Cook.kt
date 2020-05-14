package interfaces

import model.Ingredient

interface Cook {

    fun add(ingredient: Ingredient)
    fun remove(recipeId: Int)

}