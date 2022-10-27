// https://school.programmers.co.kr/learn/courses/30/lessons/67259

import kotlin.math.abs
import kotlin.math.min

class RaceTrackConstruction {

    private lateinit var costMap: Array<Array<IntArray>>
    private val moveX = intArrayOf(-1, 0, 1, 0)
    private val moveY = intArrayOf(0, -1, 0, 1)

    fun solution(board: Array<IntArray>): Int {
        val n = board.size
        val max = Int.MAX_VALUE
        costMap = Array(n) { Array(n) { IntArray(2) { max } } }
        costMap[0][0][0] = 0
        costMap[0][0][1] = 0

        // 오른쪽으로 시작
        buildTrack(board, 0, 0, n, 0, 0)
        // 아래로 시작
        buildTrack(board, 0, 0, n, 1, 0)

        costMapPrint()

        return min(costMap[n - 1][n - 1][0], costMap[n - 1][n - 1][1])
    }

    private fun buildTrack(board: Array<IntArray>, x: Int, y: Int, n: Int, direction: Int, cost: Int) {

        if (x == n - 1 && y == n - 1) {
            return
        }

        for (i in 0 until 4) {
            val nextX = x + moveX[i]
            val nextY = y + moveY[i]
            // range
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                continue
            }
            // wall
            if (board[nextX][nextY] == 1) {
                continue
            }
            val nextDirection = abs(moveX[i])
            val nextCost = if (nextDirection == direction) {
                cost + 100
            } else {
                cost + 600
            }
            if (nextCost <= costMap[nextX][nextY][nextDirection]) {
                costMap[nextX][nextY][nextDirection] = nextCost
                buildTrack(board, nextX, nextY, n, nextDirection, nextCost)
            }
        }
    }

    private fun costMapPrint() {
        costMap.forEach { intArrays ->
            intArrays.forEach { ints ->
                print("|${ints[0]}, ${ints[1]}|")
            }
            println()
        }
        println()
    }

    private fun arrPrint(board: Array<IntArray>) {
        board.forEach { ints ->
            ints.forEach { i ->
                print("|$i|")
            }
            println()
        }
        println()
    }
}

fun main() {

    val board = arrayOf(
        intArrayOf(0,1,1),
        intArrayOf(0,0,1),
        intArrayOf(1,0,0),

//        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1),
//        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
//        intArrayOf(0, 0, 0, 0, 0, 1, 0, 0),
//        intArrayOf(0, 0, 0, 0, 1, 0, 0, 0),
//        intArrayOf(0, 0, 0, 1, 0, 0, 0, 1),
//        intArrayOf(0, 0, 1, 0, 0, 0, 1, 0),
//        intArrayOf(0, 1, 0, 0, 0, 1, 0, 0),
//        intArrayOf(1, 0, 0, 0, 0, 0, 0, 0),

//        intArrayOf(0, 0, 1, 0),
//        intArrayOf(0, 0, 0, 0),
//        intArrayOf(0, 1, 0, 1),
//        intArrayOf(1, 0, 0, 0),

//        intArrayOf(0, 0, 0, 0, 0, 0),
//        intArrayOf(0, 1, 1, 1, 1, 0),
//        intArrayOf(0, 0, 1, 0, 0, 0),
//        intArrayOf(1, 0, 0, 1, 0, 1),
//        intArrayOf(0, 1, 0, 0, 0, 1),
//        intArrayOf(0, 0, 0, 0, 0, 0),

//        intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1),
//        intArrayOf(0, 0, 0, 0, 0, 1, 1, 1, 1),
//        intArrayOf(1, 1, 1, 1, 0, 1, 1, 1, 1),
//        intArrayOf(0, 0, 0, 0, 0, 1, 1, 1, 1),
//        intArrayOf(0, 1, 0, 1, 1, 1, 1, 1, 1),
//        intArrayOf(0, 1, 0, 0, 0, 1, 1, 1, 1),
//        intArrayOf(0, 1, 1, 1, 0, 1, 1, 1, 1),
//        intArrayOf(0, 0, 0, 0, 0, 1, 1, 1, 1),
//        intArrayOf(1, 1, 1, 1, 0, 0, 0, 0, 0),

    )

    println(RaceTrackConstruction().solution(board))
}