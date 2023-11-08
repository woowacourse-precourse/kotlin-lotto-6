package lotto.util

object RateOfReturnCalculator {
    fun calculateRateOfReturn(totalWinningPrice: Int, numberOfLottoTickets: Int): String {
        val rateOfReturn = totalWinningPrice.toDouble() / (numberOfLottoTickets * lottoPrice) * 100
        return String.format("%.1f", rateOfReturn)
    }
}