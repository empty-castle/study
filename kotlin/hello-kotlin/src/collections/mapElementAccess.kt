package collections

fun main(args: Array<String>) {

    val map = mapOf("key" to 42)

    val value1 = map["key"]
    val value2 = map["key2"]

    val value3: Int = map.getValue("key")

    val mapWithDefault = map.withDefault { k -> k.length }
    val value4 = mapWithDefault.getValue("key2")

    try {
        map.getValue("anotherKey")
    } catch (e: NoSuchElementException) {
        println("Message: $e")
    }


    println("value1 is $value1")
    println("value2 is $value2")
    println("value3 is $value3")
    println("value4 is $value4")
}