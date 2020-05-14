import enums.IngredientsTypes
import model.Cereal
import model.Fruit
import model.Recipe
import kotlin.system.exitProcess

val fruits = listOf(
    Fruit("Strawberry"),
    Fruit("Banana"),
    Fruit("Grapes"),
    Fruit("Apple"),
    Fruit("Orange"),
    Fruit("Pear"),
    Fruit("Cherry")
)
val cereals = listOf(
    Cereal("Wheat"),
    Cereal("Oats"),
    Cereal("Rice"),
    Cereal("Corn")
)

fun main() {

    val recipes = mutableListOf<Recipe>()

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
fun createRecipe(): Recipe {

    println(
        """
        ===========================
        ----- Create a Recipe -----
        These are the available ingredients:
        Choose whatever you need and press EXIT when you finish
        
    """.trimIndent()
    )
    var newRecipe = Recipe()

    do {

        IngredientsTypes.values().forEach {
            println("${it.ordinal} - ${it.name}")
        }
        val response: Int? = try {
            readLine()?.toInt() ?: -1
        } catch (e: NumberFormatException) {
            -1
        }
        //Now we need to print every element of the List
        when (response) {
            0 -> {
                do {
                    fruits.forEachIndexed { index, element ->
                        println("$index - ${element.name}")
                    }
                    println("Write EXIT to go back")
                    val selectedFruit: Int = try {
                        readLine()?.toInt() ?: -1
                    } catch (e: NumberFormatException) {
                        -1
                    }
                    if (selectedFruit != -1) {
                        println("How quantity we need of ${fruits[selectedFruit].name}")
                        val fruitQuantity: Int = try {
                            readLine()?.toInt() ?: 0
                        } catch (e: NumberFormatException) {
                            0
                        }
                        newRecipe.add(Fruit(fruits[selectedFruit].name, fruitQuantity))
                        println("${fruits[selectedFruit].name} Added Correctly.")
                    }
                } while (selectedFruit != -1)

            }

            1 -> {
                do {
                    cereals.forEachIndexed { index, element ->
                        println("$index - ${element.name}")
                    }
                    println("Write EXIT to go back")
                    val selectedCereal: Int = try {
                        readLine()?.toInt() ?: -1
                    } catch (e: NumberFormatException) {
                        -1
                    }
                    if (selectedCereal != -1) {
                        println("How quantity we need of ${cereals[selectedCereal].name}")
                        val cerealQuantity: Int = try {
                            readLine()?.toInt() ?: 0
                        } catch (e: NumberFormatException) {
                            0
                        }
                        newRecipe.add(Cereal(cereals[selectedCereal].name, cerealQuantity))
                        println("${cereals[selectedCereal].name} Added Correctly.")
                    }
                } while (selectedCereal != -1)
            }
            else -> {
                println("Back")
                if (newRecipe.getIngredients().size != 0) {
                    return newRecipe
                }
            }


        }

    } while (response != -1)

    return newRecipe
}


fun listRecipes(recipes: MutableList<Recipe>) {
    println(
        """
        =====================
        -- List my recipes --
    """.trimIndent()
    )

    recipes.forEachIndexed { index, element ->
        println("------------")
        println("Recipe number ${index.inc()} : ${element.toString()}")
        println("------------")
    }

    println("=================")
}