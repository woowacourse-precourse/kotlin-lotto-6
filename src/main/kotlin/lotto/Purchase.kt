package lotto

import kotlin.math.roundToLong

class Purchase(private val amount: Int) {
    init {
        require(amount % AMOUNT_UNIT_WON == 0)
        require(amount > 0)
    }

    fun calculateProfitPercentage(results: List<WinningResult>): Double {
        val totalProfitAmount: Long = results.sumOf { it.moneyWon }
        val profitPercentage: Double = totalProfitAmount.toDouble() / amount
        return profitPercentage.roundToTwoDecimalPlaces()
    }

    private fun Double.roundToTwoDecimalPlaces(): Double {
        val roundedNumberAtTwoDecimal = (this * 10).roundToLong()
        return roundedNumberAtTwoDecimal.toDouble() / 10
    }

    companion object {
        private const val AMOUNT_UNIT_WON = 1000
    }
}
