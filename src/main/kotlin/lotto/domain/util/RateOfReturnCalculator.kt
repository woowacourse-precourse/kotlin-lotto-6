package lotto.domain.util

import lotto.domain.util.const.lottoPrice
import lotto.domain.util.const.rateOfReturnDecimal

object RateOfReturnCalculator {
    fun calculateRateOfReturn(totalWinningPrice: Int, numberOfLottoTickets: Int): String {
        val rateOfReturn = totalWinningPrice.toDouble() / (numberOfLottoTickets * lottoPrice) * 100
        return String.format(rateOfReturnDecimal, rateOfReturn)
    }
}