// https://school.programmers.co.kr/learn/courses/30/lessons/132265

class CutRollCake {

    fun solution(topping: IntArray): Int {
        var answer: Int = 0

        val perToppingCnt = hashMapOf<Int, Int>()
        for (i in topping) {
            perToppingCnt.merge(i, 1) { oldValue, _ -> oldValue + 1 }
        }

        var me = 0
        val hasTopping = BooleanArray(10001) { false }

        var brother = perToppingCnt.keys.size
        for (i in topping) {
            if (!hasTopping[i]) {
                me++
                hasTopping[i] = true
            }
            perToppingCnt[i] = perToppingCnt[i]!! - 1
            if (perToppingCnt[i] == 0) {
                brother--
            }
            if (me == brother) {
                answer++
            }
        }

        return answer
    }
}

fun main() {

    val topping = intArrayOf(
        1, 2, 3, 1, 4
    )

    println(CutRollCake().solution(topping))
}