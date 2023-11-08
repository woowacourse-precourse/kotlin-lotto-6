package lotto.calculator

import kotlin.math.round

class LottoEarningRateCalculator {
    fun calculate(buyingPrice: Int, totalPrize: Long): Float {
        return (totalPrize.toEarningsRate(buyingPrice)).roundOneStep()
    }

    private fun Long.toEarningsRate(buyingPrice: Int) = (this / buyingPrice.toFloat()) * HUNDRED

    private fun Float.roundOneStep() = round(this * ONE_STEP) / ONE_STEP

    companion object {
        private const val HUNDRED = 100
        private const val ONE_STEP = 10
    }
}