import util.PrintUtil
import java.util.*
import kotlin.collections.HashMap

// https://school.programmers.co.kr/learn/courses/30/lessons/42892

/*
* 런타임 에러
* */

class TreeNode(
    val level: Int,
    val x: Int,
    val value: Int
    ) {

    var leftNode: TreeNode? = null
    var rightNode: TreeNode? = null
}

class WayFindingGame {

    private lateinit var tree: TreeNode
    private val nodeMap = hashMapOf<Int, HashMap<Int, Int>>()
    private val preOrderAnswer = mutableListOf<Int>()
    private val postOrderAnswer = mutableListOf<Int>()

    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {

        nodeinfo.forEachIndexed { index, node ->
            val nLevelNodes = nodeMap.getOrDefault(node[1], hashMapOf())
            nLevelNodes[node[0]] = index + 1
            nodeMap[node[1]] = nLevelNodes
        }

        val topLevel = Collections.max(nodeMap.keys)
        val topLevelNode = nodeMap[topLevel]!!.entries.first()

        tree = TreeNode(topLevel, topLevelNode.key, topLevelNode.value)
        makeTree(topLevel - 1, topLevelNode.key, tree, 0, 100000)

        preOrder(tree)
        postOrder(tree)

        return arrayOf(preOrderAnswer.toIntArray(), postOrderAnswer.toIntArray())
    }

    private fun preOrder(node: TreeNode?) {
        if (node != null) {
            preOrderAnswer.add(node.value)
            preOrder(node.leftNode)
            preOrder(node.rightNode)
        }
    }

    private fun postOrder(node: TreeNode?) {
        if (node != null) {
            postOrder(node.leftNode)
            postOrder(node.rightNode)
            postOrderAnswer.add(node.value)
        }
    }

    private fun makeTree(level: Int, x: Int, treeNode: TreeNode, minX: Int, maxX: Int) {

        if (level < 0) {
            return
        }

        val nLevelNodes = nodeMap[level]
        if (nLevelNodes == null) {
            makeTree(level - 1, x, treeNode, minX, maxX)
            return
        }

        treeNode.leftNode = findLeftNode(level, x, minX)
        treeNode.rightNode = findRightNode(level, x, maxX)

        if (treeNode.leftNode != null) {
            makeTree(level - 1, treeNode.leftNode!!.x, treeNode.leftNode!!, minX, x - 1)
        }

        if (treeNode.rightNode != null) {
            makeTree(level - 1, treeNode.rightNode!!.x, treeNode.rightNode!!, x + 1, maxX)
        }
    }

    private fun findLeftNode(level: Int, x: Int, minX: Int): TreeNode? {
        if (level < 0) {
            return null
        }
        val nLevelNodes = nodeMap[level] ?: return findLeftNode(level - 1, x, minX)
        for (key in nLevelNodes.keys) {
            if (key in minX until x) {
                return TreeNode(level, key, nLevelNodes[key]!!)
            }
        }
        return findLeftNode(level - 1, x, minX)
    }

    private fun findRightNode(level: Int, x: Int, maxX: Int): TreeNode? {
        if (level < 0) {
            return null
        }
        val nLevelNodes = nodeMap[level] ?: return findRightNode(level - 1, x, maxX)
        for (key in nLevelNodes.keys) {
            if (key in x + 1 .. maxX) {
                return TreeNode(level, key, nLevelNodes[key]!!)
            }
        }
        return findRightNode(level - 1, x, maxX)
    }
}

fun main() {

    val nodeinfo = arrayOf(
//        intArrayOf(10000, 10000),
        intArrayOf(1000, 1000),
        intArrayOf(0, 0),
//        intArrayOf(13, 3),
//        intArrayOf(3, 5),
//        intArrayOf(6, 1),
//        intArrayOf(1, 3),
//        intArrayOf(8, 6),
//        intArrayOf(7, 2),
//        intArrayOf(2, 2),
//        intArrayOf(4, 1),
    )

    PrintUtil.arrayIntArrayPrint(WayFindingGame().solution(nodeinfo))
}