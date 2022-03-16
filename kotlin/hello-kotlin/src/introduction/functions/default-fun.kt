package introduction.functions

fun main() {
    printMessage("First")

    printMessageWithPrefix("Second")
    printMessageWithPrefix(prefix = "Log", message = "Hello")

    println(sum(10, 10))

    println(multiply(10, 10))
}

fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun multiply(x: Int, y: Int) = x * y