package model

class Fruit(name: String, quantity: Int = 0, category: String = "Fruits"): Ingredient(name, quantity, category) {
}