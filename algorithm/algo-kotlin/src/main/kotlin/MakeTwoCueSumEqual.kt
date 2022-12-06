// https://school.programmers.co.kr/learn/courses/30/lessons/118667

class MakeTwoCueSumEqual {

    private var left = 0
    private var right = 0

    private var queue1Sum: Long = 0
    private var queue2Sum: Long = 0

    private var cnt = 0
    private var target: Long = 0

    fun solution(queue1: IntArray, queue2: IntArray): Int {

        val mergedArray = IntArray(queue1.size + queue2.size)

        queue1.forEachIndexed { index, i ->
            mergedArray[index] = i
            queue1Sum += i
        }

        val queue1Size = queue1.size

        queue2.forEachIndexed { index, i ->
            mergedArray[queue1Size + index] = i
            queue2Sum += i
        }

        if ((queue1Sum + queue2Sum) % 2 == 1.toLong()) {
            return -1
        }

        right = queue1.size
        target = (queue1Sum + queue2Sum) / 2


        popAndPush(mergedArray)

        return cnt
    }

    private fun popAndPush(mergedArray: IntArray) {

        if (queue1Sum == target) {
            return
        }

        if (left < mergedArray.size && right < mergedArray.size) {

            if (queue1Sum > target) {
                queue1Sum -= mergedArray[left]
                left++
            } else {
                queue1Sum += mergedArray[right]
                right++
            }

            cnt++
            popAndPush(mergedArray)
        } else {
            cnt = -1
            return
        }
    }
}

fun main() {

//    1 2 1 2 1 10 1 2
//              L
//              R
//    10
//    10
//    7


//    val queue1 = IntArray(299997)
//    val queue2 = IntArray(299997)
//    for (i in 0 until 299997) {
//        queue1[i] = i + 1
//    }
//    for (i in 0 until 299997) {
//        queue2[i] = 1
//    }

    val queue1 = intArrayOf(1, 1)
    val queue2 = intArrayOf(1, 5)

    println(MakeTwoCueSumEqual().solution(queue1, queue2))
}