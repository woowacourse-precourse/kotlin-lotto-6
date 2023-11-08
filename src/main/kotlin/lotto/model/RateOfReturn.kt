package lotto.model

import lotto.util.Match
import kotlin.math.roundToLong

class RateOfReturn(val data: Map<Int, Int>, val amount: Long) {

    fun getData(): String {
        val totalWinningAmount = getTotalWinningAmount()
        var averageWinningAmount = divideBydivisor(totalWinningAmount, amount)

        val scaledAmount = averageWinningAmount * PERCENT_CONVERSION_FACTOR * SCALING_FACTOR
        val roundedAmount = scaledAmount.roundToLong()
        val rateOfReturn = divideBydivisor(roundedAmount, SCALING_FACTOR)

        return PERCENTAGE_FORMAT.format(rateOfReturn)
    }

    private fun getTotalWinningAmount(): Long {
        return data
            .map { Match.getAmountForCount(it.key) * it.value }
            .sumOf { it }
    }

    private fun divideBydivisor(dividend: Long, divisor: Any): Float {
        val result = dividend / divisor.toString().toFloat()

        require(result.isFinite()) {
            DIVIDE_RESULT_ISINFINITE
        }

        return result
    }

    companion object {
        private const val PERCENT_CONVERSION_FACTOR = 100.0f
        private const val SCALING_FACTOR = 100.0f

        private const val PERCENTAGE_FORMAT = "%,.1f%%"
        private const val DIVIDE_RESULT_ISINFINITE = "수익률에서 나눈 결과가 올바르게 계산되지 않았습니다."
    }
}