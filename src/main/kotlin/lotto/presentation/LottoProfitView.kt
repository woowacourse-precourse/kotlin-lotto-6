package lotto.presentation

import LOTTO_PROFIT_MESSAGE

object LottoProfitView {
    fun printLottoProfit(profit: Double) {
        val formattedMessage = LOTTO_PROFIT_MESSAGE.format(profit)
        println(formattedMessage)
    }
}