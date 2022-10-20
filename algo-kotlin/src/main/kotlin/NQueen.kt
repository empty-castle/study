import kotlin.math.abs

class NQueen {

    private var answer = 0

    fun solution(n: Int): Int {

        val queensLoc: MutableList<Pair<Int, Int>> = mutableListOf()

        checkAll(queensLoc, n)

        return answer
    }

    private fun checkAll(queensLoc: MutableList<Pair<Int, Int>>, n: Int) {

        if (queensLoc.size == n) {
            answer++
            return
        }

        val y = queensLoc.size

        for (i in 0 until n) {
            if (!isPossibleLoc(queensLoc, i, y)) {
                continue
            }
            val newQueensLoc: MutableList<Pair<Int, Int>> = queensLoc.map { it } as MutableList<Pair<Int, Int>>
            newQueensLoc.add(Pair(i, y))
            checkAll(newQueensLoc, n)
        }
    }

    private fun isPossibleLoc(queensLoc: MutableList<Pair<Int, Int>>, x: Int, y: Int): Boolean {

        queensLoc.forEach { pair ->
            if (pair.first == x || pair.second == y) {
                return false
            }
            if (abs(pair.first - x) == abs(pair.second - y)) {
                return false
            }
        }
        return true
    }
}

fun main() {

    println(NQueen().solution(1))
}