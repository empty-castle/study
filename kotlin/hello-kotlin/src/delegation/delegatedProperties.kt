package delegation

import kotlin.reflect.KProperty

class Example {
    var p: String by Delegate()                                               // 1

    override fun toString() = "Example Class"
}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {        // 2
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) { // 2
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

/* lazy */
class LazySample {
    init {
        println("created!")            // 1
    }

    val lazyStr: String by lazy {
        println("computed!")          // 2
        "my lazy"
    }
}

/* storing properties in a Map */
class User(val map: Map<String, Any?>) {
    val name: String by map                // 1
    val age: Int by map                // 1
}

fun main() {
    val e = Example()
    println(e.p)
    e.p = "NEW"

    val sample = LazySample()         // 1
    println("lazyStr = ${sample.lazyStr}")  // 2
    println(" = ${sample.lazyStr}")  // 3

    val user = User(
        mapOf(
            "name" to "John Doe",
            "age" to 25
        )
    )
    println("name = ${user.name}, age = ${user.age}")
}