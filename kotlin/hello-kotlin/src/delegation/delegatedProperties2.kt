package delegation

var topLevelInt: Int = 0

class MyClass(var memberInt: Int) {
    var delegatedToMember: Int by ::memberInt
}

fun main() {

    val myClass = MyClass(5)
    println(myClass.delegatedToMember)
    myClass.delegatedToMember = 10
    println(myClass.delegatedToMember)
}