// https://school.programmers.co.kr/learn/courses/30/lessons/70129

class RepeatBinaryTransformation {

    private var zeroCnt = 0
    private var repeatCnt = 0

    fun solution(s: String): IntArray {

        binaryTransformation(s)

        return intArrayOf(repeatCnt, zeroCnt)
    }

    private fun binaryTransformation(s: String) {
        if (s == "1") {
            return
        }

        var newS = ""

        for (c in s.toCharArray()) {
            if (c != '0') {
                newS += c
            } else {
                zeroCnt++
            }
        }

        repeatCnt++
        binaryTransformation(newS.length.toString(2))
    }
}

fun main() {

    RepeatBinaryTransformation().solution("1111111").forEach(::println)
}