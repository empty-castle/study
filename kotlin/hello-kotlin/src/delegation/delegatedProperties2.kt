package delegation

var topLevelInt: Int = 0

class MyClass(var memberInt: Int) {
    var delegatedToMember: Int by this::memberInt
}

fun main() {


}