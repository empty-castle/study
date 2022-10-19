// https://school.programmers.co.kr/learn/courses/30/lessons/92342

class SkillCheckLevel2Test2 {

    private var answerArr = IntArray(11)
    private var maxDiff = 0

    fun solution(n: Int, info: IntArray): IntArray {

        for (i in 0 until 11) {
            val ryanInfo = IntArray(11)
            val needN = info[i] + 1
            ryanInfo[i] = needN
            val remainN = n - needN
            checkAllCase(i, remainN, info, ryanInfo)
        }

        println("=======================")

        return answerArr
    }

    private fun checkAllCase(index: Int, n: Int, peachInfo: IntArray, ryanInfo: IntArray) {

        var remainN = n
        if (index + 1 > 11) {
            return
        }

//        val newRyanInfo = ryanInfo.clone()
        for (i in index + 1 until 11) {

            for (q in ryanInfo) {
                print(q)
            }
            println()

            val newRyanInfo = ryanInfo.clone()

            val needN = peachInfo[i] + 1
            if (remainN >= needN) {
                remainN -= needN
                ryanInfo[i] = needN
            }

            checkAllCase(i, remainN, peachInfo, newRyanInfo)

//            val needN = peachInfo[i] + 1
//            if (remainN >= needN) {
//                remainN -= needN
//                ryanInfo[i] = needN
//            }
//            if (remainN > 0) {
//                checkAllCase(i, remainN, peachInfo, ryanInfo.clone())
//            }
//            if (remainN == 0) {
//                getDiff(peachInfo, ryanInfo)
//                for (i in ryanInfo) {
//                    print("|$i|")
//                }
//                println()
//                return
//            }
        }
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
        }
    }
}

fun main() {

    val n = 3
//    val info = intArrayOf(2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0)
    val info = intArrayOf(0,0,1,1,0,0,1,0,0,0,0)
    SkillCheckLevel2Test2().solution(n, info).forEach { print("|$it|") }
}