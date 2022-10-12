// https://school.programmers.co.kr/learn/courses/30/lessons/60058

class ParenthesisConversion {

    private var answer = ""

    fun solution(p: String): String {
        if (p.isEmpty()) {
            return p
        }

        answer += separateParenthesis(p)
        return answer
    }

    private fun separateParenthesis(u: String, v: String = ""): String {
        if (u.isEmpty()) {
            return ""
        }

        var nextU = ""
        var nextV = ""

        var cnt = 0
        for ((index, value) in u.withIndex()) {
            when (value) {
                '(' -> cnt--
                ')' -> cnt++
            }
            if (cnt == 0) {
                for (i in 0 .. index) {
                    nextU += u[i]
                }
                for (i in index + 1 until u.length) {
                    nextV += u[i]
                }
                break
            }
        }
        return if (uIsCorrectParenthesis(nextU)) {
            nextU + separateParenthesis(nextV)
        } else {
            var temp = "("
            temp += separateParenthesis(nextV)
            temp += ")"
            temp += rotateParenthesis(nextU.substring(1, nextU.length - 1))
            temp
        }
    }

    private fun uIsCorrectParenthesis(u: String): Boolean {
        if (u[0] == ')') return false
        return true
    }

    private fun rotateParenthesis(parenthesis: String): String {
        var result = ""
        parenthesis.forEach {
            when (it) {
                '(' -> result += ')'
                ')' -> result += '('
            }
        }
        return result
    }
}

fun main() {
    println(ParenthesisConversion().solution("()))((()"))
    println(ParenthesisConversion().solution(")()(()"))
}