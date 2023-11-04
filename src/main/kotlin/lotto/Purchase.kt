package lotto

import kotlin.math.roundToLong

class Purchase(private val amount: Int) {

    val lottos: List<Lotto>

    init {
        require(amount > 0) { Message.NumberIsZeroOrNegative }
        require(amount % AMOUNT_UNIT_WON == 0) { Message.InvalidPurchaseAmount }

        val count = amount / AMOUNT_UNIT_WON
        val lottos = mutableListOf<Lotto>()
        repeat(count) {
            lottos += Lotto.random()
        }
        this.lottos = lottos
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
        const val AMOUNT_UNIT_WON = 1_000
    }
}
