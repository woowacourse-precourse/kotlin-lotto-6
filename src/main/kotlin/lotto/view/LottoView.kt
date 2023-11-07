package lotto.view

import lotto.model.WinningLottery
import lotto.utils.ConsoleMessage
import lotto.utils.ErrorMessage

class LottoView {
    fun requestPurchaseMoneyValueMessage() {
        println(ConsoleMessage.REQUEST_PURCHASE_MONEY_VALUE)
    }
    fun requestWinningNumbersMessage() {
        println(ConsoleMessage.REQUEST_WINNING_NUMBERS)
    }
    fun requestBonusNumberMessage() {
        println(ConsoleMessage.REQUEST_BONUS_NUMBER)
    }
    fun displayInappropriateValueError() {
        println("${ErrorMessage.TITLE} ${ErrorMessage.INAPPROPRIATE_MONEY_VALUE}")
    }
    fun displayInappropriateLottoNumberError() {
        println("${ErrorMessage.TITLE} ${ErrorMessage.INAPPROPRIATE_LOTTO_VALUE}")
    }
    fun displayInappropriateBonusValueERROR() {
        println("${ErrorMessage.TITLE} ${ErrorMessage.INAPPROPRIATE_BONUS_VALUE_NAN}")
    }
    fun displayPurchasedLotteryAmountMessage(lotteryAmount: Int) {
        println("\n${lotteryAmount}${ConsoleMessage.INDICATE_PURCHASED_AMOUNT}")
    }
    fun displayLotteryNumbers(lotteryNumbers: ArrayList<List<Int>>) {
        for(item in lotteryNumbers) {
            println(item)
        }
    }
    fun displayLotteryStatisticsMessage() {
        println(ConsoleMessage.INDICATE_LOTTERY_STATISTICS)
    }
    fun displayWinningEachLotteryMessage(sameNumbers: Int, isBonusValid: Boolean, winningPrize: Int, winningAmount: Int) {
        print("${sameNumbers}${ConsoleMessage.WINNING_MESSAGE_PHASE_1}")
        if(isBonusValid) {
            print(ConsoleMessage.WINNING_MESSAGE_PHASE_BONUS)
        }
        println("${ConsoleMessage.WINNING_MESSAGE_PHASE_2}${winningPrize}${ConsoleMessage.WINNING_MESSAGE_PHASE_3}${winningAmount}${ConsoleMessage.WINNING_MESSAGE_PHASE_4}")
    }
}