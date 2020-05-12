import kotlin.system.exitProcess

val ingredients = listOf("FINISH", "Water", "Milk", "Meat", "Veggies", "Fruits", "Cereal", "Eggs", "Oil")

fun main() {

    var recipes = mutableListOf<String>()

    do {
        println(
            """
        :: Welcome to Recipe Maker ::
        
        Choose the desired option
        1. Create a recipe
        2. See my recipes
        3. Exit
    """.trimIndent()
        )
        val response: String? = readLine()
        when (response?.toInt() ?: 0) {
            1 -> recipes.add(createRecipe())
            2 -> listRecipes(recipes)
            else -> exitProcess(0)


        }

    } while (response?.toInt() ?: 0 != 3)

}

/**
 * Creates Recipe with several ingredients
 * and return it.
 */
fun createRecipe(): String {

    println(
        """
        ===========================
        ----- Create a Recipe -----
        These are the available ingredients:
        Choose whatever you need and press 0 when you finish
        
    """.trimIndent()
    )

    ingredients.forEachIndexed { index, ingredient ->
        println("$index - $ingredient")
    }

    var newRecipe = ""

    do {
        val response = readLine()?.toInt() ?: 0

        val ingredient = ingredients[response];

        println("You picked $ingredient")
        if (response != 0) {
            newRecipe = newRecipe.plus("$ingredient ")
        }
    } while (response != 0)

    return newRecipe.trimMargin()
}

fun listRecipes(recipes: List<String>) {
    println(
        """
        =====================
        -- List my recipes --
    """.trimIndent()
    )

    recipes.forEachIndexed { index, element ->
        println("------------")
        println("Recipe number ${index.inc()} : $element")
        println("------------")
    }

    println("=================")
}