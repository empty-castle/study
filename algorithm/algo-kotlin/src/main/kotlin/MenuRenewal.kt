// https://school.programmers.co.kr/learn/courses/30/lessons/72411

class MenuRenewal {

    private val combinationMap = HashMap<String, Int>()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer = mutableListOf<String>()

        orders.forEach { order ->
            val sortedOrderArr = order.toCharArray().sorted()
            sortedOrderArr.forEachIndexed { index, c ->
                makeCombination(c.toString(), index, sortedOrderArr)
            }
        }

        course.forEach { num ->
            val filteredMap = combinationMap.filter { it.key.length == num }
            if (filteredMap.isEmpty()) {
                return@forEach
            }
            val maxValue = filteredMap.maxOf { it.value }
            if (maxValue < 2) {
                return@forEach
            }
            answer.addAll(filteredMap.filterValues { it == maxValue }.keys)
        }

        return answer.sorted().toTypedArray()
    }

    private fun makeCombination(currentString: String, index: Int, order: List<Char>) {
        val orderSize = order.size
        if (index + 1 > orderSize) {
            return
        }
        for (i in index + 1 until orderSize) {
            val key = currentString + order[i]
            combinationMap[key] = combinationMap.getOrDefault(key, 0) + 1
            makeCombination(key, i, order)
        }
    }
}

fun main() {

    val orders = arrayOf<String>("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD")
    val course = intArrayOf(2, 3, 5)

    MenuRenewal().solution(orders, course).forEach(::println)
}