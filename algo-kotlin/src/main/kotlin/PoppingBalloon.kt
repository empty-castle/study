// https://school.programmers.co.kr/learn/courses/30/lessons/68646

class PoppingBalloon {

    fun solution(a: IntArray): Int {
        var answer: Int = 2
        var leftMin = a[0]
        var rightMin = Int.MIN_VALUE

        var index = 1
        while (index < a.size - 1) {
            val target = a[index]

            if (leftMin > target) {
                index++
                answer++
                leftMin = target
                continue
            }

            if (target < rightMin) {
                index++
                answer++
                continue
            }

            var possible = true
            for (i in index + 1 until a.size) {
                if (a[i] < target) {
                    possible = false
                    break
                }
            }
            index++
            if (possible) {
                answer++
            }
        }
        return answer
    }
}

fun main() {

    val a = intArrayOf(
        -16, 27, 65, -2, 58, -92, -71, -68, -61, -33
    )

    println(PoppingBalloon().solution(a))
}