import java.util.Stack

// https://school.programmers.co.kr/learn/courses/30/lessons/81303

class Node(val value: Int, var prev: Int?, var post: Int?)

class EditTable {

    private var cursor = 0
    private val deletedRow = Stack<Int>()
    private val table = mutableListOf<Node>()

    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var answer: StringBuilder = StringBuilder()

        cursor = k

        init(n)

        cmd.forEach {
            when (it[0]) {
                'U' -> up(it.split(" ")[1].toInt())
                'D' -> down(it.split(" ")[1].toInt())
                'C' -> delete()
                'Z' -> rollback()
            }
        }

        val dictionary = deletedRow.associateWith { 0 }
        for (i in 0 until n) {
            if (dictionary.containsKey(i)) {
                answer.append("X")
                continue
            }
            answer.append("O")
        }

        return answer.toString()
    }

    private fun init(n: Int) {

        table.add(Node(0, null, 1))
        for (i in 1 until n - 1) {
            table.add(Node(i, i - 1, i + 1))
        }
        table.add(Node(n - 1, n - 2, null))
    }

    private fun up(x: Int) {
        var cnt = 0
        while (cnt < x) {
            cursor = table[cursor].prev!!
            cnt++
        }
    }

    private fun down(x: Int) {
        var cnt = 0
        while (cnt < x) {
            cursor = table[cursor].post!!
            cnt++
        }
    }

    private fun delete() {
        val currentRow = table[cursor]
        if (currentRow.prev != null) table[currentRow.prev!!].post = currentRow.post
        if (currentRow.post != null) table[currentRow.post!!].prev = currentRow.prev
        deletedRow.add(cursor)
        if (currentRow.post != null) {
            cursor = currentRow.post!!
        } else {
            up(1)
        }
    }

    private fun rollback() {
        val rollbackNode = table[deletedRow.pop()]
        if (rollbackNode.prev != null) table[rollbackNode.prev!!].post = rollbackNode.value
        if (rollbackNode.post != null) table[rollbackNode.post!!].prev = rollbackNode.value
    }
}

fun main() {

    val n = 8
    val k = 2
    val cmd = arrayOf(
        "D 4", "C", "C", "C",
//        "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"
//        "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"
//        "C", "C", "C", "C", "Z"
    )

    println(EditTable().solution(n, k, cmd))
}