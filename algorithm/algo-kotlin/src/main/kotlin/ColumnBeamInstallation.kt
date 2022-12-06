import util.PrintUtil

// https://school.programmers.co.kr/learn/courses/30/lessons/60061

class Structure() {
    var column = 0
    var beam = 0
}

class ColumnBeamInstallation {

    private var answer = mutableListOf<IntArray>()
    private lateinit var map: Array<Array<Structure>>

    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        map = Array(n + 1) { Array(n + 1) { Structure() } }

        build_frame.forEach {
            val x = it[0]
            val y = it[1]
            if (it[2] == 0) {
                if (it[3] == 1) installColumn(x, y) else uninstallColumn(x, y)
            } else {
                if (it[3] == 1) installBeam(x, y) else uninstallBeam(x, y)
            }
        }

        map.forEach { structures ->
            structures.forEach { structure ->
                print("(${structure.column}, ${structure.beam}) | ")
            }
            println()
        }
        println()

        countingMap()

        return answer.toTypedArray()
    }

    private fun installColumn(x: Int, y: Int) {
        if (isPossibleColumn(x, y)) map[x][y].column = 1
    }

    private fun uninstallColumn(x: Int, y: Int) {
        map[x][y].column = 0
        if (map[x][y + 1].column == 1 && !isPossibleColumn(x, y + 1)) {
            map[x][y].column = 1
            return
        }
        if (map[x][y + 1].beam == 1 && !isPossibleBeam(x, y + 1)) {
            map[x][y].column = 1
            return
        }
        if (x - 1 >= 0 && map[x - 1][y + 1].beam == 1 && !isPossibleBeam(x - 1, y + 1)) {
            map[x][y].column = 1
            return
        }
    }

    private fun isPossibleColumn(x: Int, y: Int): Boolean {
        if (y == 0) return true
        if (map[x][y - 1].column == 1) return true
        if (map[x][y].beam == 1) return true
        if (x - 1 >= 0 && map[x - 1][y].beam == 1) return true
        return false
    }

    private fun installBeam(x: Int, y: Int) {
        if (isPossibleBeam(x, y)) map[x][y].beam = 1
    }

    private fun uninstallBeam(x: Int, y: Int) {
        map[x][y].beam = 0
        if (map[x][y].column == 1 && !isPossibleColumn(x, y)) {
            map[x][y].beam = 1
            return
        }
        if (map[x + 1][y].column == 1 && !isPossibleColumn(x + 1, y)) {
            map[x][y].beam = 1
            return
        }
        if (x - 1 >= 0 && map[x - 1][y].beam == 1 && !isPossibleBeam(x - 1, y)) {
            map[x][y].beam = 1
            return
        }
        if (map[x + 1][y].beam == 1 && !isPossibleBeam(x + 1, y)) {
            map[x][y].beam = 1
            return
        }
    }

    private fun isPossibleBeam(x: Int, y: Int): Boolean {
        if (map[x][y - 1].column == 1) return true
        if (map[x + 1][y - 1].column == 1) return true
        if ((x - 1 >= 0 && map[x -1][y].beam == 1) && map[x + 1][y].beam == 1) return true
        return false
    }

    private fun countingMap() {
        for (x in map.indices) {
            for (y in map.indices) {
                val structure = map[x][y]
                if (structure.column == 1) answer.add(intArrayOf(x, y, 0))
                if (structure.beam == 1) answer.add(intArrayOf(x, y, 1))
            }
        }
    }
}

fun main() {

    val n = 5

    // x y (0기둥1보) (0삭제1설치)
    val build_frame = arrayOf(
//        intArrayOf(1, 0, 0, 1),
//        intArrayOf(1, 1, 1, 1),
//        intArrayOf(2, 1, 0, 1),
//        intArrayOf(2, 2, 1, 1),
//        intArrayOf(5, 0, 0, 1),
//        intArrayOf(5, 1, 0, 1),
//        intArrayOf(4, 2, 1, 1),
//        intArrayOf(3, 2, 1, 1),

//        intArrayOf(0, 0, 0, 1),
//        intArrayOf(2, 0, 0, 1),
//        intArrayOf(4, 0, 0, 1),
//        intArrayOf(0, 1, 1, 1),
//        intArrayOf(1, 1, 1, 1),
//        intArrayOf(2, 1, 1, 1),
//        intArrayOf(3, 1, 1, 1),
//        intArrayOf(2, 0, 0, 0),
//        intArrayOf(1, 1, 1, 0),
//        intArrayOf(2, 2, 0, 1),

        intArrayOf(0, 0, 0, 1),
        intArrayOf(0, 1, 0, 1),
        intArrayOf(0, 2, 0, 1),
        intArrayOf(0, 3, 0, 1),
        intArrayOf(0, 4, 0, 1),
        intArrayOf(0, 5, 0, 1),
        intArrayOf(0, 5, 1, 1),
        intArrayOf(0, 4, 1, 1),
        intArrayOf(0, 3, 1, 1),
        intArrayOf(0, 2, 1, 1),
        intArrayOf(0, 1, 1, 1),
        intArrayOf(1, 3, 0, 1),
        intArrayOf(0, 3, 1, 0),
    )

    PrintUtil.arrayIntArrayPrint(ColumnBeamInstallation().solution(n, build_frame))
}