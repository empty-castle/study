// https://school.programmers.co.kr/learn/courses/30/lessons/64062

class CrossingSteppingBridge {

    var answer = 0

    fun solution(stones: IntArray, k: Int): Int {

        var left = 1
        var right = 200000000

        while (left <= right) {
            val mid = (right + left) / 2
            var cnt = 0
            for (stone in stones) {
                if (stone - mid <= 0) {
                    cnt++
                } else {
                    cnt = 0
                }
                if (cnt >= k) {
                    break
                }
            }
            if (cnt >= k) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return left
    }
}

fun main() {

    val stones = intArrayOf(
        2, 4, 5, 3, 2, 1, 4, 2, 5, 1
    )
    val k = 3

    println(CrossingSteppingBridge().solution(stones, k))
}