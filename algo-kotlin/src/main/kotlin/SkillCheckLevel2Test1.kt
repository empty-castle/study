import kotlin.math.max

class SkillCheckLevel2Test1 {

    private val menus = hashMapOf<String, Int>()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {

        var answer = mutableListOf<String>()

        orders.forEach { order ->
            val sortedOrderArr = order.toCharArray().sorted()
            sortedOrderArr.forEachIndexed { index, c ->
                makeCombination(c.toString(), index, sortedOrderArr)
            }
        }

        course.forEach { size ->
            val filteredMap = menus.filter { it.key.length == size }
            if (filteredMap.isEmpty()) {
                return@forEach
            }
            val maxCnt = filteredMap.maxOf { it.value }
            if (maxCnt < 2) {
                return@forEach
            }
            answer.addAll(filteredMap.filterValues { it == maxCnt }.keys)
        }

        return answer.sorted().toTypedArray()
    }

    fun makeCombination(currentString: String, index: Int, order: List<Char>) {

        if (index + 1 > order.size) {
            return
        }
        for (i in index + 1 until order.size) {
            val key = currentString + order[i]
            menus[key] = menus.getOrDefault(key, 0) + 1
            makeCombination(key, i, order)
        }
    }
}

fun main() {

    val orders = arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH")
    val course = intArrayOf(2, 3, 4)

    SkillCheckLevel2Test1().solution(orders, course).forEach { print("|$it|") }
}