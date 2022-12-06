import kotlin.math.sqrt

class FindDecimals {

    private var answer = mutableSetOf<Int>()

    fun solution(numbers: String): Int {

        for (i in numbers.indices) {
            val visitedIndex = IntArray(numbers.length)
            visitedIndex[i] = 1
            makeNumbers(numbers[i].toString(), numbers, visitedIndex)
        }

        println(answer)
        return answer.size
    }

    private fun makeNumbers(currentString: String, numbers: String, visitedIndex: IntArray) {
        println(currentString)
        if (isPrime(currentString.toInt())) {
            answer.add(currentString.toInt())
        }

        for (i in numbers.indices) {
            if (visitedIndex[i] == 1) {
                continue
            }
            val nextString = currentString + numbers[i]
            val newVisitedIndex = visitedIndex.clone()
            newVisitedIndex[i] = 1

            makeNumbers(nextString, numbers, newVisitedIndex)
        }
    }

    private fun isPrime(number: Int): Boolean {

        if (number < 2) {
            return false
        }

        if (number == 2) {
            return true
        }

        for (i in 2..sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) {
                return false
            }
        }

        return true
    }
}

fun main() {

    println(FindDecimals().solution("1234567"))
}