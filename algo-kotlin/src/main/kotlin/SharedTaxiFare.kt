// https://school.programmers.co.kr/learn/courses/30/lessons/72413

import kotlin.math.min

class SharedTaxiFare {

    private lateinit var loadMap: Array<IntArray>

    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {

        init(n, fares)
        floyd(n)
        return answer(n, s, a, b)
    }

    private fun floyd(n: Int) {

        for (i in 1 .. n) {
            for (j in 1 .. n) {
                for (k in 1 .. n) {
                    loadMap[j][k] = min(loadMap[j][k], loadMap[j][i] + loadMap[i][k])
                }
            }
        }
    }

    private fun answer(n: Int, s: Int, a: Int, b: Int): Int {
        var answer = Int.MAX_VALUE
        for (i in 1 .. n) {
            answer = min(answer, loadMap[s][i] + loadMap[i][a] + loadMap[i][b])
        }
        return answer
    }

    private fun init(n: Int, fares: Array<IntArray>) {
        loadMap = Array(n + 1) { r -> IntArray(n + 1) { c -> if (r == c) 0 else (100000 * n + 1) } }
        fares.forEach { ints ->
            ints[2].let {
                loadMap[ints[0]][ints[1]] = it
                loadMap[ints[1]][ints[0]] = it
            }
        }
    }
}

fun main() {

    val n = 6 // 노드 개수
    val s = 4 // 스타트
    val a = 6 // A 도착
    val b = 2 // B 도착
    val fares = arrayOf(
        // [c, d, f]: c 와 d 지점 사이의 택시요금은 f
        intArrayOf(4, 1, 10),
        intArrayOf(3, 5, 24),
        intArrayOf(5, 6, 2),
        intArrayOf(3, 1, 41),
        intArrayOf(5, 1, 24),
        intArrayOf(4, 6, 50),
        intArrayOf(2, 4, 66),
        intArrayOf(2, 3, 22),
        intArrayOf(1, 6, 25)
    )

    println(SharedTaxiFare().solution(n, s, a, b, fares))
}