package introduction.functions

fun main() {

    printAll("Hello", "Hallo", "Salut", "Hola", "你好")

    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "
    )

    log("spread", "operator")
}

fun printAll(vararg message: String) {
    for (m in message) println(m)
}

fun printAllWithPrefix(vararg message: String, prefix: String) {
    for (m in message) println(prefix + m)
}

fun log(vararg entries: String) {
    printAll(*entries)
}