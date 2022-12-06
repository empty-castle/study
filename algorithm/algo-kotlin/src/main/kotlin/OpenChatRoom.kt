//https://school.programmers.co.kr/learn/courses/30/lessons/42888?language=kotlin

class OpenChatRoom {

    private val userMap = HashMap<String, String>()

    fun solution(record: Array<String>): Array<String> {
        val tempAnswer = mutableListOf<String>()

        val actRecord = mutableListOf<Pair<String, String>>()

        record.forEach { it ->
            val splitRecord: List<String> = it.split(" ")
            val id = splitRecord[1]

            when (splitRecord[0]) {
                "Enter" -> {
                    userMap[id] = splitRecord[2]
                    actRecord.add(Pair("Enter", id))
                }
                "Leave" -> actRecord.add(Pair("Leave", id))
                "Change" -> userMap[id] = splitRecord[2]
            }
        }

        actRecord.forEach {
            tempAnswer.add(printAct(it))
        }

        return tempAnswer.toTypedArray()
    }

    private fun printAct(act: Pair<String, String>): String {
        return when (act.first) {
            "Enter" -> "${userMap[act.second]}님이 들어왔습니다."
            "Leave"-> "${userMap[act.second]}님이 나갔습니다."
            else -> ""
        }
    }
}

fun main() {
    for (s in OpenChatRoom().solution(
        arrayOf(
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        )
    )) {
        println(s)
    }
}