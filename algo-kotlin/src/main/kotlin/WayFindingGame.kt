import util.PrintUtil

// https://school.programmers.co.kr/learn/courses/30/lessons/42892

class WayFindingGame {

    private val tree = hashMapOf<Int, HashMap<Int, Int>>()
    private val preOrderAnswer = mutableListOf<Int>()
    private val postOrderAnswer = mutableListOf<Int>()

    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        nodeinfo.forEachIndexed { index, node ->
            val nLevelNodes = tree.getOrDefault(node[1], hashMapOf())
            nLevelNodes[node[0]] = index + 1
            tree[node[1]] = nLevelNodes
        }

        val topLevel = tree.keys.last()
        val topLevelNode = tree[topLevel]!!.entries.first()

        /*
        *
        * TreeNode 만들기
        *
        * 주의점: 해당 줄에 없다해도 다음 줄에는 있을수 있음 마지막까지 노드 찾아야 함 X Y
        *
        * */

        return arrayOf(preOrderAnswer.toIntArray(), postOrderAnswer.toIntArray())
    }
}

fun main() {

    val nodeinfo = arrayOf(
        intArrayOf(5, 3),
        intArrayOf(11, 5),
        intArrayOf(13, 3),
        intArrayOf(3, 5),
        intArrayOf(6, 1),
        intArrayOf(1, 3),
        intArrayOf(8, 6),
        intArrayOf(7, 2),
        intArrayOf(2, 2),
        intArrayOf(4, 1),
//        intArrayOf(0, 1),
    )

    PrintUtil.arrayIntArrayPrint(WayFindingGame().solution(nodeinfo))
}