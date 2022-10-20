class PlainSquare {

    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0

        val gcd = gcd(w, h)

        val cnt = (w / gcd) + (h / gcd) - 1

        return (w.toLong() * h.toLong()) - (cnt.toLong() * gcd.toLong())
    }

    private fun gcd(a: Int, b: Int): Int =
        if (b != 0) gcd(b, a % b) else a
}

fun main() {

    println(PlainSquare().solution(3, 4))
}