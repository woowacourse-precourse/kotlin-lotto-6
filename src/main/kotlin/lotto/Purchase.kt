package lotto

import kotlin.math.roundToLong

// TODO: amount 대신 금액으로 명확하게 바꾸기
class Purchase(private val amount: Int) {

    private val lottos: List<Lotto>

    val lottoCount: Int get() = lottos.size

    init {
        require(amount > 0) { Message.NumberIsZeroOrNegativeError }
        require(amount % AMOUNT_UNIT_WON == 0) { Message.InvalidPurchaseAmountError }

        val count = amount / AMOUNT_UNIT_WON
        val lottos = mutableListOf<Lotto>()
        repeat(count) {
            lottos += Lotto.random()
        }
        this.lottos = lottos
    }

    fun check(winningNumber: WinningNumber): WinningStatics {
        val winnings = lottos.map { winningNumber.check(it) }
        val profitPercentage = calculateProfitPercentage(winnings)
        return WinningStatics(winnings = winnings, profitPercentage = profitPercentage)
    }

    private fun calculateProfitPercentage(winnings: List<Winning>): Double {
        val totalProfitAmount: Long = winnings.sumOf { it.moneyWon }
        val profitPercentage: Double = totalProfitAmount.toDouble() / amount * 100
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
