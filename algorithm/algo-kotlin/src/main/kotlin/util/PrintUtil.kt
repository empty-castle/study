package util

object PrintUtil {

    fun arrayIntArrayPrint(arr: Array<IntArray>) {
        for (anies in arr) {
            for (any in anies) {
                print("|$any|")
            }
            println()
        }
        println()
    }

    fun arrayHashMapPrint(arr: Array<HashMap<Int, Int>>) {
        arr.forEach { hashMap ->
            hashMap.forEach { k, v ->
                println("$k: $v")
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