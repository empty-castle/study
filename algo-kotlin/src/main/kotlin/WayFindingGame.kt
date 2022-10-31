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

        findWay(topLevel, topLevelNode.key, 0, 100000, topLevelNode.value)

        return arrayOf(preOrderAnswer.toIntArray(), postOrderAnswer.toIntArray())
    }

    private fun findWay(level: Int, x: Int, minX: Int, maxX: Int, value: Int) {
        if (level < 0) {
            preOrderAnswer.add(value)
            postOrderAnswer.add(value)
            return
        }

        val nextLevelNodes = tree[level - 1]
        if (nextLevelNodes == null) {
            findWay(level - 1, x, minX, maxX, value)
            return
        }

        var leftKey = -1
        var rightKey = -1
        for (key in nextLevelNodes.keys) {
            if (key in minX until x) {
                leftKey = key
            } else if (key in x + 1 .. maxX) {
                rightKey = key
            }
        }
            preOrderAnswer.add(value)
        if (leftKey == -1) {
            findWay(level - 1, x, minX, maxX, value)
        } else {
            findWay(level - 1, leftKey, 0, x, nextLevelNodes[leftKey]!!)
            postOrderAnswer.add(value)
        }
        if (rightKey == -1) {
            findWay(level - 1, x, minX, maxX, value)
        } else {
            findWay(level - 1, rightKey, x, maxX, nextLevelNodes[rightKey]!!)
        }
    }

//    private fun findWay(level: Int, x: Int, minX: Int, maxX: Int, value: Int) {
//        val nextLevelNodes = tree[level - 1]
//        if (nextLevelNodes == null) {
//            if (level == 0) {
//                preOrderAnswer.add(value)
//                postOrderAnswer.add(value)
//                return
//            }
//            findWay(level - 1, x, minX, maxX, value)
//            return
//        }
//
//        preOrderAnswer.add(value)
//        for (i in x - 1 downTo  minX + 1) {
//            val nextValue = nextLevelNodes[i] ?: continue
//            findWay(level - 1, i, 0, x, nextValue)
//        }
//
//        for (i in x + 1 .. maxX) {
//            val nextValue = nextLevelNodes[i] ?: continue
//            findWay(level - 1, i, x, maxX, nextValue)
//        }
//        postOrderAnswer.add(value)
//    }
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