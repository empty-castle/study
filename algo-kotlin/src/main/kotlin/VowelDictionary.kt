// https://school.programmers.co.kr/learn/courses/30/lessons/84512

class VowelDictionary {

    private var cnt = 0
    private var answer = 0

    fun solution(word: String): Int {

        val vowel = arrayOf("A", "E", "I", "O", "U")

        dfs("", vowel, word)

        return answer
    }

    private fun dfs(currentString: String, vowel: Array<String>, targetWord: String) {
        if (currentString.length == 5) {
            return
        }
        for (s in vowel) {
            val nextString = currentString + s
            cnt++
            if (nextString == targetWord) {
                answer = cnt
                break
            }
            dfs(nextString, vowel, targetWord)
        }

    }
}

fun main() {
    print(VowelDictionary().solution("AAAAE"))
}