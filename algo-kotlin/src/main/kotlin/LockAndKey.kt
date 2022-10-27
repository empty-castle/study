// https://school.programmers.co.kr/learn/courses/30/lessons/60059

class LockAndKey {

    private val keyCases = mutableListOf<Array<IntArray>>()

    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {

        val keySize = key.size
        val lockSize = lock.size

        keyCases.add(findPeak(key))
        for (i in 1 until 4) {
            keyCases.add(rotate(keyCases[i - 1], keySize))
        }

        val slots = findSlot(lock)
        if (slots.isEmpty()) {
            return true
        }

        // key 를 상하좌우 가능한만큼 움직여준다.
        for (i in (keySize * -1) until lockSize) {
            for (j in (keySize * -1) until lockSize) {
                for (keyCase in keyCases) {
                    var matched = 0
                    var possiblePeakCnt = 0
                    for (peak in keyCase) {
                        val x = peak[0] + i
                        val y = peak[1] + j
                        if (x < 0 || y < 0 || x >= lock.size || y >= lockSize) {
                            continue
                        }
                        possiblePeakCnt++
                        for (slot in slots) {
                            if (slot[0] == x && slot[1] == y) {
                                matched++
                                break
                            }
                        }
                    }
                    if (matched == possiblePeakCnt && possiblePeakCnt == slots.size) {
                        return true
                    }

                }
            }
        }
        return false
    }

    private fun findSlot(lock: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        for (i in lock.indices) {
            for (j in lock.indices) {
                if (lock[i][j] == 0) {
                    result.add(intArrayOf(i, j))
                }
            }
        }
        return result.toTypedArray()
    }

    private fun findPeak(key: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        for (i in key.indices) {
            for (j in key.indices) {
                if (key[i][j] == 1) {
                    result.add(intArrayOf(i, j))
                }
            }
        }
        return result.toTypedArray()
    }

    private fun rotate(peaks: Array<IntArray>, m: Int): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        for (peak in peaks) {
            result.add(intArrayOf(peak[1], m - peak[0] - 1))
        }
        return result.toTypedArray()
    }

    private fun mapPrint(m: Array<IntArray>) {
        for (ints in m) {
            for (int in ints) {
                print("|$int|")
            }
            println()
        }
        println()
    }
}

fun main() {

    val key = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 1),
    )

    val lock = arrayOf(
        intArrayOf(1, 1, 1, 1),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(1, 1, 1, 0),
    )

    println(LockAndKey().solution(key, lock))
}