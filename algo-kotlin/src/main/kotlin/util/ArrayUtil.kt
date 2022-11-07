package util

object ArrayUtil {

    fun toArrayIntArray(arrayString: String): Array<IntArray> {

        val array = arrayString.substring(2, arrayString.length - 2).split("],[")
        val result = mutableListOf<IntArray>()
        array.forEach {
            val intArray = it.split(",")
            result.add(intArrayOf(intArray[0].toInt(), intArray[1].toInt()))
        }
        return result.toTypedArray()
    }
}