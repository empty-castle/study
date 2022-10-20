class Fibonacci {

    private var prevCnt1: Long = 0
    private var prevCnt2: Long = 1

    fun solution(n: Int): Int {

        var nextCnt: Long = 0
        var index = 2

        while (n >= index) {
            nextCnt = (prevCnt1 + prevCnt2) % 1234567
            prevCnt1 = prevCnt2
            prevCnt2 = nextCnt
            index++
        }
        return nextCnt.toInt()
    }
}

fun main() {

    println(Fibonacci().solution(100000))
}