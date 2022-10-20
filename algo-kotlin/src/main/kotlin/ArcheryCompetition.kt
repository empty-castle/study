// https://school.programmers.co.kr/learn/courses/30/lessons/92342

class ArcheryCompetition {

    private var answerArr = IntArray(11)
    private var maxDiff = 0

    fun solution(n: Int, info: IntArray): IntArray {

        for (i in 0 until 11) {
            val ryanInfo = IntArray(11)
            val needN = info[i] + 1
            ryanInfo[i] = needN
            if (needN > n) {
                continue
            }
            val remainN = n - needN
            checkAllCase(i, remainN, info, ryanInfo)
        }

        if (maxDiff == 0) {
            return intArrayOf(-1)
        }
        return answerArr
    }

    private fun checkAllCase(index: Int, n: Int, peachInfo: IntArray, ryanInfo: IntArray) {

        var remainN = n
        if (index + 1 > 11) {
            return
        }

        for (i in index + 1 until 11) {

            if (i == 10) {
                ryanInfo[10] = remainN
                break
            }
            val newRyanInfo = ryanInfo.clone()
            val needN = peachInfo[i] + 1
            // 남은 화살이 없어 불가능한 경우
            if (needN > remainN) {
                continue
            }
            // 남은 화살이 있어도 다음으로 넘기는 경우
            checkAllCase(i, remainN, peachInfo, newRyanInfo)
            // 남은 화살이 있어 쏘는 경우
            remainN -= needN
            newRyanInfo[i] = needN
            checkAllCase(i, remainN, peachInfo, newRyanInfo)
        }

        for (i in ryanInfo) {
            print("|$i|")
        }
        println()

        getDiff(peachInfo, ryanInfo)
    }

    private fun getDiff(peachInfo: IntArray, ryanInfo: IntArray) {
        var peachPoint = 0
        var ryanPoint = 0

        for (i in 0 until 11) {
            val ryanN = ryanInfo[i]
            val peachN = peachInfo[i]
            val point = 10 - i

            if (ryanN == 0 && peachN == 0) {
                continue
            }
            if (ryanN > peachN) {
                ryanPoint += point
            } else {
                peachPoint += point
            }
        }

        val currentDiff = ryanPoint - peachPoint
        if (currentDiff > maxDiff) {
            answerArr = ryanInfo
            maxDiff = currentDiff
        } else if (currentDiff == maxDiff) {
            for (i in 10 downTo 0) {
                val ryanN = ryanInfo[i]
                val answerN = answerArr[i]
                if (ryanN == answerN) {
                    continue
                }
                if (answerN > ryanN) {
                    break
                }
                answerArr = ryanInfo
                break
            }
        }
    }
}

fun main() {

    val n = 2
    val info = intArrayOf(
        1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0
    )
    SkillCheckLevel2Test2().solution(n, info).forEach { print("|$it|") }
}