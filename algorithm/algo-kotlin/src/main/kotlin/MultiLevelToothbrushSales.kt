import kotlin.math.floor

// https://school.programmers.co.kr/learn/courses/30/lessons/77486

class MultiLevelToothbrushSales {

    private val referralMap = hashMapOf<String, String>()
    private val resultMap = linkedMapOf<String, Int>()

    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {

        for (i in enroll.indices) {
            referralMap[enroll[i]] = referral[i]
            resultMap[enroll[i]] = 0
        }

        for (i in seller.indices) {
            if (amount[i] == 0) {
                continue
            }
            sellToothbrush(seller[i], amount[i] * 100)
        }

        return resultMap.values.toIntArray()
    }

    private fun sellToothbrush(seller: String, profit: Int) {

        if (seller == "-") {
            return
        }

        val tithe = (profit * 0.1).toInt()
        val realProfit = profit - tithe

        resultMap[seller] = resultMap[seller]!! + realProfit
        if (tithe > 0) {
            sellToothbrush(referralMap[seller]!!, tithe)
        }
    }
}

fun main() {

    // enroll => referral
    val enroll = arrayOf(
        "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"
    )
    val referral = arrayOf(
        "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"
    )

    // seller => amount
    val seller = arrayOf(
        "young", "john", "tod", "emily", "mary"
    )
    val amount = intArrayOf(
        12, 4, 2, 5, 10
    )

    MultiLevelToothbrushSales().solution(enroll, referral, seller, amount).forEach { print("|$it|") }
}