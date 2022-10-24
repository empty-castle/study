import java.util.HashMap

class JewelryShopping {

    var answer = IntArray(2)
    var size = Int.MAX_VALUE

    fun solution(gems: Array<String>): IntArray {

        checkDisplayStand(gems, hashMapOf<String, Int>(), gems.toSet().size)

        return answer
    }

    private fun checkDisplayStand(gems: Array<String>, gemMap: HashMap<String, Int>, targetSize: Int) {
        var left = 0

        for (i in gems.indices) {
            val gem = gems[i]
            gemMap[gem] = gemMap.getOrDefault(gem, 0) + 1

            while (gemMap.getOrDefault(gems[left], 0) > 1) {
                gemMap[gems[left]] = gemMap[gems[left]]!! - 1
                left++
            }

            if (gemMap.size == targetSize && size > (i - left)) {
                size = i - left
                answer[0] = left + 1
                answer[1] = i + 1
            }
        }
    }
}

fun main() {

    val gems = arrayOf(
        "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
//        "XYZ", "XYZ", "XYZ"
//        "AA", "AB", "AC", "AA", "AC"
//        "ZZZ", "YYY", "NNNN", "YYY", "BBB"
//        "A", "A", "A", "B", "B"
//        "A", "B", "B", "B", "B", "B", "B", "C", "B", "A"
    )

    JewelryShopping().solution(gems).forEach { println("|$it|") }
}