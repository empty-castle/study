package controlFlow.loops

fun main() {

    val cakes = listOf<String>("carrot", "cheese", "chocolate")
    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
}