// https://school.programmers.co.kr/learn/courses/30/lessons/118667

class MakeTwoCueSumEqual {

    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = -2

        val targetNum = (queue1.sum() + queue2.sum()) / 2



        return answer
    }
}

fun main() {

    val queue1 = intArrayOf(3, 2, 7, 2)
    val queue2 = intArrayOf(4, 6, 5, 1)

    println(MakeTwoCueSumEqual().solution(queue1, queue2))
}