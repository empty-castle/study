class Network {

    lateinit var visitedComputer: Array<Boolean>

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        visitedComputer = Array(n) { false }

        for ((computerNum, _) in computers.withIndex()) {
            if (visitedComputer[computerNum]) {
                continue
            }
            visitedComputer[computerNum] = true
            checkComputer(computers, computerNum)
            answer++
        }

        return answer
    }

    private fun checkComputer(computers: Array<IntArray>, index: Int) {

        val computer = computers[index]

        for ((computerNum, value) in computer.withIndex()) {
            if (computerNum == index) {
                continue
            }
            if (visitedComputer[computerNum]) {
                continue
            }
            if (value == 1) {
                visitedComputer[computerNum] = true
                checkComputer(computers, computerNum)
            }
        }
    }
}

fun main() {

    val n = 3
    val computers = arrayOf(
        intArrayOf(1,1,0),
        intArrayOf(1,1,1),
        intArrayOf(0,1,1),
    )

    println(Network().solution(n, computers))
}