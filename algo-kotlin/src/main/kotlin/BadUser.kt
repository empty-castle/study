// https://school.programmers.co.kr/learn/courses/30/lessons/64064

class BadUser {

    private lateinit var visitedUserIds: BooleanArray
    private val result = mutableSetOf<String>()

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        visitedUserIds = BooleanArray(user_id.size)
        checkBannedId(user_id, banned_id)
        return result.size
    }

    private fun checkBannedId(user_id: Array<String>, banned_id: Array<String>, save: MutableList<String> = mutableListOf()) {

        if (save.size == banned_id.size) {
            result.add(save.sorted().joinToString(""))
            return
        }

        user_id.forEachIndexed { index, userId ->
            if (!visitedUserIds[index] && checkWord(userId, banned_id[save.size])) {
                visitedUserIds[index] = true
                val copySave = save.toMutableList()
                copySave.add(userId)
                checkBannedId(user_id, banned_id, copySave)
                visitedUserIds[index] = false
            }
        }
    }

    private fun checkWord(userId: String, bannedId: String): Boolean {
        if (userId.length != bannedId.length) {
            return false
        }
        for (i in userId.indices) {
            if (bannedId[i] == '*') {
                continue
            }
            if (userId[i] != bannedId[i]) {
                return false
            }
        }
        return true
    }

}

fun main() {

    val userId = arrayOf<String>("frodo", "fradi", "crodo", "abc123", "frodoc")
    val bannedId = arrayOf<String>("fr*d*", "*rodo", "******", "******")

    println(BadUser().solution(userId, bannedId))
}