package lotto.view

import lotto.utils.ConsoleMessage
import lotto.utils.ErrorMessage

class LottoView {
    fun requestPurchaseMoneyValueMessage() {
        println(ConsoleMessage.REQUEST_PURCHASE_MONEY_VALUE)
    }
    fun requestWinningNumbersMessage() {
        println(ConsoleMessage.REQUEST_WINNING_NUMBERS)
    }
    fun displayInappropriateValueError() {
        println("${ErrorMessage.TITLE} ${ErrorMessage.INAPPROPRIATE_MONEY_VALUE}")
    }
    fun displayInappropriateLottoNumberError() {
        println("${ErrorMessage.TITLE} ${ErrorMessage.INAPPROPRIATE_LOTTO_VALUE}")
    }
    fun displayPurchasedLotteryAmountMessage(lotteryAmount: Int) {
        println("\n${lotteryAmount}${ConsoleMessage.INDICATE_PURCHASED_AMOUNT}")
    }
    fun displayLotteryNumbers(lotteryNumbers: ArrayList<List<Int>>) {
        for(item in lotteryNumbers) {
            println(item)
        }
    }
}