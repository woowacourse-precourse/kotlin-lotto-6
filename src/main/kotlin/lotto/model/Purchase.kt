package lotto.model

import kotlin.math.roundToLong

class Purchase(private val amountWon: Int) {

    private val lottos: List<Lotto>

    val lottoCount: Int get() = lottos.size

    init {
        require(amountWon > 0) { Message.NumberIsZeroOrNegativeError }
        require(amountWon % AMOUNT_UNIT_WON == 0) { Message.InvalidPurchaseAmountError }

        val count = amountWon / AMOUNT_UNIT_WON
        this.lottos = createRandomLottos(count)
    }

    private fun createRandomLottos(count: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(count) {
            lottos += Lotto.random()
        }
        return lottos
    }

    fun check(winningNumber: WinningNumber): WinningStatics {
        val winnings = lottos.map { winningNumber.check(it) }
        val profitPercentage = calculateProfitPercentage(winnings)

        return WinningStatics(winnings, profitPercentage)
    }

    private fun calculateProfitPercentage(winnings: List<Winning>): Double {
        val totalPriceAmount: Long = winnings.sumOf { it.priceWon }
        val profitPercentage: Double = totalPriceAmount.toDouble() / amountWon * 100
        return profitPercentage.roundToTwoDecimalPlaces()
    }

    private fun Double.roundToTwoDecimalPlaces(): Double {
        val roundedNumberAtTwoDecimal = (this * 10).roundToLong()
        return roundedNumberAtTwoDecimal.toDouble() / 10
    }

    override fun toString(): String {
        return lottos.joinToString("\n") { it.toString() }
    }

    companion object {
        const val AMOUNT_UNIT_WON = 1_000
    }
}
