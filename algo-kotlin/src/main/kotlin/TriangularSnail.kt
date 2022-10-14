// https://school.programmers.co.kr/learn/courses/30/lessons/68645

class TriangularSnail {

    fun solution(n: Int): IntArray {
        val answer = Array(n) { r -> IntArray(r + 1) }

        var value = 1
        var moveCnt = n
        var col = 0
        var row = -1

        while (moveCnt > 0) {

            for (i in 0 until moveCnt) {
                row++
                answer[row][col] = value
                value++
            }

            moveCnt--

            for (i in 0 until moveCnt) {
                col++
                answer[row][col] = value
                value++
            }

            moveCnt--

            for (i in 0 until moveCnt) {
                row--
                col--
                answer[row][col] = value
                value++
            }

            moveCnt--
        }

        return answer.flatMap { it.asIterable() }.toIntArray()
    }
}

fun main() {

    TriangularSnail().solution(6)
        .forEach { print("|$it|") }
}