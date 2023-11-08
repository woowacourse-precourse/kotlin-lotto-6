package lotto.model

import lotto.util.Match
import kotlin.math.roundToLong

class RateOfReturn(val data: Map<Int, Int>, val amount: Int) {

    fun get(): String {
        val totalWinningAmount = data
            .map { Match.getAmountForCount(it.key) * it.value }
            .sumOf { it }

        val averageWinningAmount = totalWinningAmount.toDouble() / amount
        val scaledAmount = averageWinningAmount * PERCENT_CONVERSION_FACTOR * SCALING_FACTOR
        val roundedAmount = scaledAmount.roundToLong()
        return "%,.1f%%".format(roundedAmount / SCALING_FACTOR)
    }

    companion object {
        private const val PERCENT_CONVERSION_FACTOR = 100.0
        private const val SCALING_FACTOR = 100.0
    }
}