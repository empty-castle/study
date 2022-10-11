// https://school.programmers.co.kr/learn/courses/30/lessons/64065

class Tuple {

    fun solution(s: String): IntArray {

        val splitSet = s.substring(2, s.length - 2)
            .split("},{")

        var answer = IntArray(splitSet.size)
        val orderedElementsSet = arrayOfNulls<List<String>>(splitSet.size)

        splitSet.forEach {
            it.split(",")
                .also { it -> orderedElementsSet[it.size - 1] = it }
        }

        orderedElementsSet.forEachIndexed { index, elementsSet ->
            elementsSet!!.forEach { element ->
                if (!answer.contains(element.toInt())) {
                    answer[index] = element.toInt()
                }
            }
        }

        return answer
    }
}

fun main() {
    Tuple().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}").forEach(::println)
}