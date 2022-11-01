import java.util.LinkedList
import java.util.Stack

// https://school.programmers.co.kr/learn/courses/30/lessons/81303

/*
*
* Linked List 의 개념을 활용해서 풀어내자
*
* */

class Node(value: Int, prev: Int, post: Int)

class EditTable {

    private var cursor = 0
    private val deletedRow = Stack<Int>()
    private val table = mutableListOf<Node>()

    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var answer: StringBuilder = StringBuilder()

        cursor = k
        for (i in 0 until n) {
            table.add(i)
        }

//        cmd.forEach {
//            when (it[0]) {
//                'U' -> up(it.split(" ")[1].toInt())
//                'D' -> down(it.split(" ")[1].toInt())
//                'C' -> delete()
//                'Z' -> rollback()
//            }
//        }
//
//        table.forEach {
//            if (answer.length != it) {
//                while (answer.length < it) {
//                    answer.append("X")
//                }
//                answer.append("O")
//            } else {
//                answer.append("O")
//            }
//        }

        return answer.toString()
    }

    private fun up(x: Int) {
        cursor -= x
    }

    private fun down(x: Int) {
        cursor += x
    }

    private fun delete() {
        deletedRow.add(table.removeAt(cursor))
        if (cursor == table.size) {
            cursor = table.size - 1
        }
    }

    private fun rollback() {
        val index = deletedRow.pop()
        if (index > table.size) {
            table.add(index)
        } else {
            table.add(index, index)
        }
        if (index < cursor) {
            cursor++
        }
    }
}

fun main() {

    val n = 8
    val k = 2
    val cmd = arrayOf(
//        "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"
//        "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"
        "C", "C", "C", "C", "Z"
    )

    println(EditTable().solution(n, k, cmd))
}