package collections

fun main() {

    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")
    val empty = emptyList<String>()

    /* filter */
    val positives = numbers.filter { x -> x > 0 }
    val negatives = numbers.filter { it < 0 }

    /* map */
    val doubled = numbers.map { x -> x * 2 }
    val tripled = numbers.map { it * 3 }

    /* any */
    val anyNegative = numbers.any { it < 0 }
    val anyGT6 = numbers.any { it > 6 }

    /* all */
    val allEven = numbers.all { it % 2 == 0 }
    val allLess6 = numbers.all { it < 6 }

    /* none */
    val allEvenNone = numbers.none { it % 2 == 1 }
    val allLess6None = numbers.none { it > 6 }

    /* find, findLast */
    val find = words.find { it.startsWith("some") }
    val findLast = words.findLast { it.startsWith("some") }
    val nothing = words.find { it.contains("nothing") }

    /* first, last*/
    val first = numbers.first()
    val last = numbers.last()
    val firstEven = numbers.first { it % 2 == 0 }
    val lastOdd = numbers.last { it % 2 != 0 }

    /* firstOrNull, lastOrNull */
    val firstOrNull = empty.firstOrNull()
    val lastOrNull = empty.lastOrNull()

    val firstF = words.firstOrNull { it.startsWith('f') }
    val firstZ = words.firstOrNull { it.startsWith('z') }
    val lastF = words.lastOrNull { it.endsWith('f') }
    val lastZ = words.lastOrNull { it.endsWith('z') }

    /* count */
    val totalCount = numbers.count()
    val evenCount = numbers.count { it % 2 == 0 }
}