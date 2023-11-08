package lotto.model

import lotto.util.Match
import kotlin.math.roundToLong

class RateOfReturn(val data: Map<Int, Int>, val amount: Int) {

    fun getData(): String {
        val totalWinningAmount = getTotalWinningAmount()

        val averageWinningAmount = totalWinningAmount.toDouble() / amount
        val scaledAmount = averageWinningAmount * PERCENT_CONVERSION_FACTOR * SCALING_FACTOR
        val roundedAmount = scaledAmount.roundToLong()

        return PERCENTAGE_FORMAT.format(roundedAmount / SCALING_FACTOR)
    }

    private fun getTotalWinningAmount(): Long {
        return data
            .map { Match.getAmountForCount(it.key) * it.value }
            .sumOf { it }
    }

    companion object {
        private const val PERCENT_CONVERSION_FACTOR = 100.0
        private const val SCALING_FACTOR = 100.0

        private const val PERCENTAGE_FORMAT = "%,.1f%%"
    }
}