import util.ArrayUtil
import util.PrintUtil

// https://school.programmers.co.kr/learn/courses/30/lessons/92343

class SheepAndWolf {

    private lateinit var binaryTree: Array<IntArray>
    private var maxSheepCnt = 0

    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        binaryTree = Array(info.size) { IntArray(info.size) }
        edges.forEach {
            binaryTree[it[0]][it[1]] = 1
        }

        PrintUtil.arrayIntArrayPrint(binaryTree)

        sheepOrWolf(0, info, 0, 0, mutableListOf())

        return maxSheepCnt
    }

    private fun sheepOrWolf(currentNode: Int, info: IntArray, prevSheepCnt: Int, prevWolfCnt: Int, possibleVisitNodes: MutableList<Int>) {
        var sheepCnt = prevSheepCnt
        var wolfCnt = prevWolfCnt
        if (info[currentNode] == 0) sheepCnt++ else wolfCnt++
        if (sheepCnt <= wolfCnt) {
            if (maxSheepCnt < sheepCnt) maxSheepCnt = sheepCnt
            return
        }

        binaryTree[currentNode].forEachIndexed { index, i ->
            if (i == 1) possibleVisitNodes.add(index)
        }

        if (possibleVisitNodes.isEmpty()) {
            if (maxSheepCnt < sheepCnt) maxSheepCnt = sheepCnt
            return
        }

        possibleVisitNodes.forEachIndexed { index, i ->
            val newPossibleVisitNodes = mutableListOf<Int>()
            newPossibleVisitNodes.addAll(possibleVisitNodes)
            newPossibleVisitNodes.removeAt(index)
            sheepOrWolf(i, info, sheepCnt, wolfCnt, newPossibleVisitNodes)
        }
    }
}

fun main() {

    val info = intArrayOf(
        0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1
    )

    val edges =
        ArrayUtil.toArrayIntArray("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]")
//        ArrayUtil.toArrayIntArray("[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]")

    println(SheepAndWolf().solution(info, edges))
}