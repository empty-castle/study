import util.PrintUtil

// https://school.programmers.co.kr/learn/courses/30/lessons/92344

class UndestroyedBuilding {

    private lateinit var cumulativeSum: Array<IntArray>
    private var n = 0
    private var m = 0
    private var answer = 0

    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        n = board.size
        m = board[0].size

        cumulativeSum = Array(n + 1) { IntArray(m + 1) { 0 } }

        prepareCumulativeSum(skill)

        calculateCumulativeSum()

        applyBoard(board)

        countingUndestroyedBuilding(board)

        return answer
    }

    private fun prepareCumulativeSum(skill: Array<IntArray>) {

        for (ints in skill) {
            val type = if (ints[0] == 1) -1 else 1
            val x1 = ints[1]
            val y1 = ints[2]
            val x2 = ints[3]
            val y2 = ints[4]
            val value = ints[5]

            cumulativeSum[x1][y1] = cumulativeSum[x1][y1] + (value * type)
            cumulativeSum[x1][y2 + 1] = cumulativeSum[x1][y2 + 1] + (-value * type)
            cumulativeSum[x2 + 1][y1] = cumulativeSum[x2 + 1][y1] + (-value * type)
            cumulativeSum[x2 + 1][y2 + 1] = cumulativeSum[x2 + 1][y2 + 1] + (value * type)
        }

    }

    private fun calculateCumulativeSum() {
        for (y in 0 .. m) {
            for (x in 1 .. n) {
                cumulativeSum[x][y] = cumulativeSum[x - 1][y] + cumulativeSum[x][y]
            }
        }
        for (x in 0 .. n) {
            for (y in 1 .. m) {
                cumulativeSum[x][y] = cumulativeSum[x][y - 1] + cumulativeSum[x][y]
            }
        }
    }

    private fun applyBoard(board: Array<IntArray>) {
        for (x in 0 until n) {
            for (y in 0 until m) {
                board[x][y] = board[x][y] + cumulativeSum[x][y]
            }
        }
    }

    private fun countingUndestroyedBuilding(board: Array<IntArray>) {
        for (x in 0 until n) {
            for (y in 0 until m) {
                if (board[x][y] > 0) {
                    answer++
                }
            }
        }
    }
}

fun main() {

    val board = arrayOf(
//        intArrayOf(5, 5, 5, 5, 5),
//        intArrayOf(5, 5, 5, 5, 5),
//        intArrayOf(5, 5, 5, 5, 5),
//        intArrayOf(5, 5, 5, 5, 5),

        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )

    val skill = arrayOf(
//        intArrayOf(1, 0, 0, 3, 4, 4),
//        intArrayOf(1, 2, 0, 2, 3, 2),
//        intArrayOf(2, 1, 0, 3, 1, 2),
//        intArrayOf(1, 0, 1, 3, 3, 1),

        intArrayOf(1, 1, 1, 2, 2, 4),
        intArrayOf(1, 0, 0, 1, 1, 2),
        intArrayOf(2, 2, 0, 2, 0, 100),
    )

    println(UndestroyedBuilding().solution(board, skill))
}