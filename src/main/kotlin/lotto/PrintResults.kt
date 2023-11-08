package lotto

import java.math.BigDecimal

class PrintResults {
    companion object {
        private const val INITIAL_NUM = 0
        private const val DECIMAL_PLACE = 1
    }
    fun printResults(prizeCounts: IntArray, rateOfReturn: BigDecimal) {
        val prizeDescriptions = listOf(
            MessageConstants.THREE_MATCHES,
            MessageConstants.FOUR_MATCHES,
            MessageConstants.FIVE_MATCHES,
            MessageConstants.FIVE_MATCHES_AND_BONUS_NUMBER_MATCH,
            MessageConstants.SIX_MATCHES
        )

        println(MessageConstants.WINNING_STATISTICS)
        for (i in INITIAL_NUM until prizeCounts.size) {
            println("${prizeDescriptions[i]} - ${prizeCounts[i]}${MessageConstants.UNIT}")
        }

        println("${MessageConstants.YIELD_MESSAGE_START}${roundDigit(rateOfReturn, DECIMAL_PLACE)}${MessageConstants.YIELD_MESSAGE_END}")
    }

    fun roundDigit(number: BigDecimal, digits: Int): BigDecimal {
        return number.setScale(digits, BigDecimal.ROUND_HALF_UP)
    }
}