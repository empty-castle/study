package scopeFunctions

data class Member(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

fun writeCreationLog(p: Member) {
    println("A new person ${p.name} was created.")
}

fun main() {
    val jake = Member("Jake", 30, "Android developer")   // 1
        .also {                                          // 2
            writeCreationLog(it)                         // 3
        }
}