// https://school.programmers.co.kr/learn/courses/30/lessons/77485

class RotateMatrixBorders {

    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()

        val map = Array(rows) { r -> IntArray(columns) { c -> columns * r + (c + 1)} }

        for (query in queries) {
            answer.add(rotate(map, query))
        }

        return answer.toIntArray()
    }

    private fun rotate(map: Array<IntArray>, query: IntArray): Int {

        val (x1, y1, x2, y2) = query.map { it - 1 }

        val saveValue = map[x1][y1]
        var minNum = saveValue

        // left line
        for (i in x1 until x2) {
            map[i][y1] = map[i + 1][y1]
            if (map[i + 1][y1] < minNum) {
                minNum = map[i + 1][y1]
            }
        }

        // bottom line
        for (i in y1 until y2) {
            map[x2][i] = map[x2][i + 1]
            if (map[x2][i + 1] < minNum) {
                minNum = map[x2][i + 1]
            }
        }

        // right line
        for (i in x2 downTo x1 + 1) {
            map[i][y2] = map[i - 1][y2]
            if (map[i - 1][y2] < minNum) {
                minNum = map[i - 1][y2]
            }
        }

        // top line
        for (i in y2 downTo y1 + 1) {
            map[x1][i] = map[x1][i - 1]
            if (map[x1][i - 1] < minNum) {
                minNum = map[x1][i - 1]
            }
        }

        map[x1][y1 + 1] = saveValue

        return minNum
    }
}

fun main() {

    val rows = 6
    val columns = 6
    val queries = arrayOf<IntArray>(intArrayOf(2,2,5,4), intArrayOf(3,3,6,6), intArrayOf(5,1,6,3))

    RotateMatrixBorders().solution(rows, columns, queries).forEach(::println)
}
