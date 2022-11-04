// https://school.programmers.co.kr/learn/courses/30/lessons/72414

/*
* 테스트 케이스 더 필요 => 범위 지정이 잘못된 느낌, 논리는 맞음
* */

class AdInsertion {

    private lateinit var timeTable: IntArray

    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {

        val playSecond = convertToSecond(play_time)
        timeTable = IntArray(playSecond + 2)

        logs.forEach { countingViewer(it) }
        calculateCumulativeSum()

        return convertToTime(checkBestAdTime(convertToSecond(adv_time)))
    }

    private fun checkBestAdTime(advSecond: Int): Int {
        var startSecond = 1
        var endSecond = advSecond + 1

        var maxCumulativePlayTime = 0
        var cumulativePlayTime = 0
        var bestAdStartSecond = 0

        for (i in 0 until endSecond) {
            maxCumulativePlayTime += timeTable[i]
        }
        cumulativePlayTime = maxCumulativePlayTime

        val timeTableSize = timeTable.size - 1
        while (endSecond < timeTableSize) {
            val nextCumulativePlayTime = cumulativePlayTime + timeTable[endSecond] - timeTable[startSecond]
            if (nextCumulativePlayTime > maxCumulativePlayTime) {
                maxCumulativePlayTime = nextCumulativePlayTime
                bestAdStartSecond = startSecond + 1
            }
            cumulativePlayTime = nextCumulativePlayTime
            endSecond++
            startSecond++
        }

        return bestAdStartSecond
    }

    private fun countingViewer(log: String) {
        val split = log.split("-")
        val startSecond = convertToSecond(split[0])
        val endSecond = convertToSecond(split[1])

        timeTable[startSecond] = timeTable[startSecond] + 1
        timeTable[endSecond] = timeTable[endSecond + 1] - 1
    }

    private fun calculateCumulativeSum() {
        for (i in 1 until timeTable.size) {
            timeTable[i] = timeTable[i - 1] + timeTable[i]
        }
    }

    private fun convertToSecond(time: String): Int {
        val split = time.split(":")
        val h = split[0].toInt()
        val m = split[1].toInt()
        val s = split[2].toInt()

        return h * 3600 + m * 60 + s
    }

    private fun convertToTime(second: Int): String {
        val h = intPadStart(second / 3600)
        var m = intPadStart((second % 3600) / 60)
        var s = intPadStart(second % 60)

        return "$h:$m:$s"
    }

    private fun intPadStart(time: Int): String {
        return time.toString().padStart(2, '0')
    }
}

fun main() {

//    val play_time = "02:03:55"
//    val play_time = "99:59:59"
//    val play_time = "50:00:00"
    val play_time = "00:00:10"

//    val adv_time = "00:14:15"
//    val adv_time = "25:00:00"
//    val adv_time = "50:00:00"
    val adv_time = "00:00:03"

    val logs = arrayOf(
//        "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"
//        "69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"
//        "15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"
        "00:00:01-00:00:05", "00:00:05-00:00:9", "00:00:02-00:00:03", "00:00:06-00:00:07"
    )

    println(AdInsertion().solution(play_time, adv_time, logs))
}