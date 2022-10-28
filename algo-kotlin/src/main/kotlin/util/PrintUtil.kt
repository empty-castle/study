package util

object PrintUtil {

    fun array2Print(arr: Array<Array<Any>>) {
        for (anies in arr) {
            for (any in anies) {
                print("|$any|")
            }
            println()
        }
        println()
    }

    fun mapSSPrint(map: HashMap<String, String>) {
        map.forEach { (k, v) -> print("($k, $v) | ") }
        println("\n======")
    }

    fun mapSIPrint(map: HashMap<String, Int>) {
        map.forEach { (k, v) -> print("($k, $v) | ") }
        println("\n======")
    }
}