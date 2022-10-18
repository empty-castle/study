//https://school.programmers.co.kr/learn/courses/30/lessons/92335

import kotlin.math.sqrt

class FindNumberDecimalsInKNumber {

    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0

        val kStr = n.toString(k)
        var startIndex = 0
        for (i in kStr.indices) {
            if (kStr[i] == '0') {
                val targetString = kStr.substring(startIndex, i)
                if (targetString.isEmpty()) {
                    startIndex = i + 1
                    continue
                }
                val targetNumber = targetString.toLong()
                if (isPrime(targetNumber)) {
                    if (isCollectPrime(kStr, startIndex, i)) {
                        answer++
                    }
                }
                startIndex = i + 1
            }
        }

//        fixme startIndex 와 더불어 endIndex 를 두고 startIndex 가 endIndex 랑 같아질 때까지 반복한다고 하면 아래 마지막이 필요 없지 않을까?

        val targetString = kStr.substring(startIndex, kStr.length)
        if (targetString.isNotEmpty()) {
            val targetNumber = targetString.toLong()
            if (isPrime(targetNumber)) {
                if (isCollectPrime(kStr, startIndex, kStr.length)) {
                    answer++
                }
            }
        }

        return answer
    }

    private fun isPrime(number: Long): Boolean {

        if (number < 2) {
            return false
        }

        if (number == 2L) {
            return true
        }

        for (i in 2 ..sqrt(number.toDouble()).toInt()) {
            if (number % i == 0L) {
                return false
            }
        }

        return true
    }

    private fun isCollectPrime(kStr: String, startIndex: Int, endIndex: Int): Boolean {

        var prevNumber = 0
        var afterNumber = 0
        prevNumber = if (startIndex - 1 < 0) 0 else kStr[startIndex - 1].toString().toInt()
        afterNumber = if (endIndex + 1 > kStr.length) 0 else kStr[endIndex].toString().toInt()

        if (prevNumber != 0 || afterNumber != 0) {
            return false
        }
        return true
    }
}

fun main() {

    val n = 36
    val k = 3

    println(FindNumberDecimalsInKNumber().solution(n, k))
}