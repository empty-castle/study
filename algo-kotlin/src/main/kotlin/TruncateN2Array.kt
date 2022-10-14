// https://school.programmers.co.kr/learn/courses/30/lessons/87390

class TruncateN2Array {

    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = mutableListOf<Int>()

        for (i in left .. right) {""
            val row = (i / n).toInt()
            val col = (i % n).toInt()
            answer.add(if (row > col) row + 1 else col + 1)
        }

        return answer.toIntArray()
    }
}

fun main() {

    val n = 4
    val left: Long = 7
    val right: Long = 14

    TruncateN2Array().solution(n, left, right).forEach(::print)
}