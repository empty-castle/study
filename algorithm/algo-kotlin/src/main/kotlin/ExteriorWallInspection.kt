// https://school.programmers.co.kr/learn/courses/30/lessons/60062

class ExteriorWallInspection {

    /*
    *
    * dist 각각을 투입해서 엮이는 weak 지점 지워내는 것을 반복
    * 시계 방향, 반시계 방향 => 1 to 10 이랑 10 to 1 은 같다 => 반시계 필요 없음ㅋ`
    * 경로 안에 포함되는 weak 지점
    *
    * */

    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        var answer = 0



        return answer
    }
}

fun main() {

    val n = 12
    val weak = intArrayOf(
        1, 5, 6, 10
    )
    val dist = intArrayOf(
        1, 2, 3, 4
    )

    println(ExteriorWallInspection().solution(n, weak, dist))
}