package lotto

class PrintResults {
    fun printResults(prizeCounts: IntArray, rateOfReturn: Double) {
        val prizeDescriptions = listOf(
                MessageConstants.THREE_MATCHES,
                MessageConstants.FOUR_MATCHES,
                MessageConstants.FIVE_MATCHES,
                MessageConstants.FIVE_MATCHES_AND_BONUS_NUMBER_MATCH,
                MessageConstants.SIX_MATCHES
        )

        println(MessageConstants.WINNING_STATISTICS)
        for (i in 0 until prizeCounts.size) {
            println("${prizeDescriptions[i]} - ${prizeCounts[i]}${MessageConstants.UNIT}")
        }

        println("${MessageConstants.YIELD_MESSAGE_START}${roundDigit(rateOfReturn, 1)}${MessageConstants.YIELD_MESSAGE_END}")
    }

    fun roundDigit(number: Double, digits: Int): Double {
        return Math.round(number * Math.pow(10.0, digits.toDouble())) / Math.pow(10.0, digits.toDouble())
    }
}