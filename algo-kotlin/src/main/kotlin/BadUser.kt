class BadUser {

    private lateinit var checkUserIds: Array<Boolean?>
    private lateinit var checkBannedIds: Array<Boolean?>
    private var cnt = 0

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        var answer = 0

        checkUserIds = arrayOfNulls<Boolean>(user_id.size)
        checkBannedIds = arrayOfNulls<Boolean>(banned_id.size)

//        user_id.forEach { checkBannedId(it, banned_id) }

//        checkBannedId()

        return answer
    }

    private fun checkBannedId(user_id: Array<String>, banned_id: Array<String>) {

        user_id.forEachIndexed { index, userId ->
            banned_id.forEachIndexed { index, banId ->

            }
        }


        /*
        *
        * targetId 랑 banned_id 랑 매칭
        *   만약 성공하면 다음 targetId 가져와서 확인 안한 banned_id에 매칭
        *   만약 실패하면 다음 targetId 가져와서 확인
        *
        * targetId랑 banned_id 모두 방문 했냐 안 했냐를 기준으로 체크 index 는 무조건 0 부터 끝까지 갈기면 된다.
        *
        * 끝까지 성공하면 cnt ++ 해서 마지막 cnt 가 결과값이 되는 걸로 하면 정답?
        *
        * */

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
    val bannedId = arrayOf<String>("fr*d*", "abc1**")

    println(BadUser().solution(userId, bannedId))
}