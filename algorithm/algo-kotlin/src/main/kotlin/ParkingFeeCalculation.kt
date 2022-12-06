import kotlin.math.ceil

// https://school.programmers.co.kr/learn/courses/30/lessons/92341

class ParkingFeeCalculation {

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer = mutableListOf<Int>()

        val parkingCarsFee = HashMap<Int, Int>()

        val defaultTime = fees[0]
        val defaultFee = fees[1]
        val unitTime = fees[2]
        val unitFee = fees[3]

        val parkedCars = HashMap<Int, Int>()

        records.forEach { record ->
            val recordSplit = record.split(" ")
            val time = recordSplit[0]
            val carNumber = recordSplit[1].toInt()
            val history = recordSplit[2]

            if (history == "IN") {
                parkedCars[carNumber] = timeStringToInt(time)
            } else {
                parkingCarsFee[carNumber] =
                    parkingCarsFee.getOrDefault(carNumber, 0) + timeStringToInt(time) - parkedCars[carNumber]!!
                parkedCars.remove(carNumber)
            }
        }

        if (parkedCars.size > 0) {
            parkedCars.forEach { (carNumber, _) ->
                parkingCarsFee[carNumber] =
                    parkingCarsFee.getOrDefault(carNumber, 0) + timeStringToInt("23:59") - parkedCars[carNumber]!!
            }
        }

        parkingCarsFee
            .keys
            .sorted()
            .forEach { carNumber ->
                answer.add(defaultFee + (ceil((parkingCarsFee[carNumber]!! - defaultTime).toDouble() / unitTime).toInt()).coerceAtLeast(0) * unitFee)
            }

        return answer.toIntArray()
    }

    private fun timeStringToInt(time: String): Int {
        val timeSplit = time.split(":")
        return (timeSplit[0].toInt() * 60) + (timeSplit[1].toInt())
    }
}

fun main() {

    val fees = intArrayOf(180, 5000, 10, 600)
    val records = arrayOf(
        "05:34 5961 IN",
        "06:00 0000 IN",
        "06:34 0000 OUT",
        "07:59 5961 OUT",
        "07:59 0148 IN",
        "18:59 0000 IN",
        "19:09 0148 OUT",
        "22:59 5961 IN",
        "23:00 5961 OUT")

    ParkingFeeCalculation().solution(fees, records).forEach(::println)
}