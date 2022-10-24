class TargetNumber {

    var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {

        checkAllCase(numbers, target, 0, 0)

        return answer
    }

    private fun checkAllCase(numbers: IntArray, target: Int, currentNum: Int, index: Int) {

        if (index >= numbers.size) {
            if (currentNum == target) {
                answer++
            }
            return
        }

        val next1Num = currentNum + numbers[index]
        val next2Num = currentNum - numbers[index]

        checkAllCase(numbers, target, next1Num, index + 1)
        checkAllCase(numbers, target, next2Num, index + 1)
    }
}

fun main() {

    val numbers = intArrayOf(1, 1, 1, 1, 1)
    val target = 3

    println(TargetNumber().solution(numbers, target))
}