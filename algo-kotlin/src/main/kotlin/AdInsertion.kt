class AdInsertion {

    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        var answer: String = ""

        /*
        *
        * 총 재생 시간 만큼 arr 만듬
        *
        * 각 logs 를 분석해서 arr 에 시청 시간을 더함
        * => 이 때 누적합을 사용하면 더 좋을까?
        *
        * 계산된 arr 을 슬라이딩 윈도우 방식으로 탐색 최고점 찾기
        * => 시작 지점을 시청자 MAX 값으로 설정하는게 더 좋은가? 안됨  111411 < 333333
        *
        * */

        println(convertToSecond(adv_time))
        println(convertToSecond(play_time))

        println(convertToTime(convertToSecond(adv_time) - convertToSecond(play_time)))

        return answer
    }

    private fun convertToSecond(time: String): Int {
        val split = time.split(":")
        val h = split[0].toInt()
        val m = split[1].toInt()
        val s = split[2].toInt()

        return h * 3600 + m * 60 + s
    }

    private fun convertToTime(second: Int): String {
        val h = second / 3600
        var m = (second % 3600) / 60
        var s = second % 60

        return "$h:$m:$s"
    }
}

fun main() {

    val play_time = "01:30:59"
    val adv_time = "01:37:44"
    val logs = arrayOf("")

    println(AdInsertion().solution(play_time, adv_time, logs))
}