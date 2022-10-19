class CountingAfterQuadCompression {

    private var zeroCnt = 0
    private var oneCnt = 0

    fun solution(arr: Array<IntArray>): IntArray {

        var answer = Array(2) { 0 }


        quadCompression(arr,0, 0, arr.size)

        answer[0] = zeroCnt
        answer[1] = oneCnt

        return answer.toIntArray()
    }

    private fun quadCompression(arr: Array<IntArray>, x: Int, y: Int, size: Int) {

        if (size == 1) {
            checkAreaNum(arr, x, y, size)
            return
        }

        if (isSameValueArea(arr, x, y, size)) {
            checkCnt(arr[x][y])
            return
        }

        val nextSize = size / 2

        quadCompression(arr, x, y, nextSize)
        quadCompression(arr, x + nextSize, y, nextSize)
        quadCompression(arr, x, y + nextSize, nextSize)
        quadCompression(arr, x + nextSize, y + nextSize, nextSize)
    }

    private fun isSameValueArea(arr: Array<IntArray>, x: Int, y: Int, size: Int): Boolean {

        var targetValue = arr[x][y]

        for (i in x until x + size) {
            for (j in y until y + size) {
                if (targetValue != arr[i][j]) {
                    return false
                }
            }
        }

        return true
    }

    private fun checkAreaNum(arr: Array<IntArray>, x: Int, y: Int, size: Int) {
        for (i in x until x + size) {
            for (j in y until y + size) {
                checkCnt(arr[i][j])
            }
        }
    }

    private fun checkCnt(num: Int) {
        if (num == 1) {
            oneCnt++
        } else {
            zeroCnt++
        }
    }
}

fun main() {

    val arr: Array<IntArray> = arrayOf(
        intArrayOf(1,1,0,0,),
        intArrayOf(1,0,0,0,),
        intArrayOf(1,0,0,1,),
        intArrayOf(1,1,1,1,),
    )
    CountingAfterQuadCompression().solution(arr).forEach { print("|$it|") }
}