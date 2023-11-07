package lotto.util

import lotto.numberOfLottoTickets

object RateOfReturnCalculator {
    fun calculateRateOfReturn(totalWinningPrice: Int): String {
        val rateOfReturn = totalWinningPrice.toDouble() / (numberOfLottoTickets * lottoPrice) * 100
        return String.format("%.1f", rateOfReturn)
    }
}