// https://school.programmers.co.kr/learn/courses/30/lessons/81302#fnref1

class CheckTheDistance {

    fun solution(places: Array<Array<String>>): IntArray {
        var answer = Array<Int>(5) { 0 }

        var room: Array<Array<String>> = Array(5) { Array(5) { "O" } }

        for ((index, place) in places.withIndex()) {
            for ((i, str) in place.withIndex()) {
                for ((j, c) in str.withIndex()) {
                    room[i][j] = c.toString()
                }
            }
            answer[index] = roomCheck(room)
        }


        for (strings in room) {
            println()
            for (string in strings) {
                print("|$string|")
            }
        }

        println()

        return answer.toIntArray()
    }

    private fun roomCheck(room: Array<Array<String>>): Int {
        for ((x, tables) in room.withIndex()) {
            for ((y, table) in tables.withIndex()) {
                if (table == "X") {
                    continue
                }
                if (!checkDistance(room, x, y)) {
                    return 0
                }
            }
        }
        return 1
    }

    private fun checkDistance(room: Array<Array<String>>, x: Int, y: Int): Boolean {
        var cnt = 0
        var targetCnt = 0

        if (x - 1 > -1 && room[x - 1][y] == "P") cnt++
        if (x + 1 < 5 && room[x + 1][y] == "P") cnt++
        if (y - 1 > -1 && room[x][y - 1] == "P") cnt++
        if (y + 1 < 5 && room[x][y + 1] == "P") cnt++

        when(room[x][y]) {
            "P" -> targetCnt = 0
            "O" -> targetCnt = 1
        }

        return cnt <= targetCnt
    }
}

fun main() {

    val places = arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
    )
    CheckTheDistance().solution(places).forEach { print("|$it|") }
}