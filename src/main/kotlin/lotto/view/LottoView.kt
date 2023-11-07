package lotto.view

import lotto.model.LottoResult
import lotto.utils.ConsoleMessage
import lotto.utils.ErrorMessage
import lotto.utils.Values

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
    fun displayWinningResult(lottoRank: LottoResult) {
        displayWinningAmount(WinningLottery.FIFTH, lottoRank.component5())
        displayWinningAmount(WinningLottery.FOURTH, lottoRank.component4())
        displayWinningAmount(WinningLottery.THIRD, lottoRank.component3())
        displayWinningAmount(WinningLottery.SECOND, lottoRank.component2())
        displayWinningAmount(WinningLottery.FIRST, lottoRank.component1())
    }
    private fun displayWinningAmount(winning: WinningLottery, rank: Int) {
        print("${winning.conditionValue}${ConsoleMessage.WINNING_MESSAGE_PHASE_1}")
        if(winning == WinningLottery.SECOND) {
            print(ConsoleMessage.WINNING_MESSAGE_PHASE_BONUS)
        }
        print(ConsoleMessage.WINNING_MESSAGE_PHASE_2)
        displayPrizeValue(winning)
        println("${ConsoleMessage.WINNING_MESSAGE_PHASE_3}${rank}${ConsoleMessage.WINNING_MESSAGE_PHASE_4}")
    }
    private fun displayPrizeValue(winning: WinningLottery) {
        when (winning) {
            WinningLottery.FIFTH -> print("%,d".format(Values.WINNING_PRIZE_FIFTH))
            WinningLottery.FOURTH -> print("%,d".format(Values.WINNING_PRIZE_FOURTH))
            WinningLottery.THIRD -> print("%,d".format(Values.WINNING_PRIZE_THIRD))
            WinningLottery.SECOND -> print("%,d".format(Values.WINNING_PRIZE_SECOND))
            WinningLottery.FIRST -> print("%,d".format(Values.WINNING_PRIZE_FIRST))
        }
    }
    fun displayBenefitRate(rate: Double) {
        println("${ConsoleMessage.BENEFIT_RATE_MESSAGE_PHASE_1}${rate}${ConsoleMessage.BENEFIT_RATE_MESSAGE_PHASE_2}")
    }
    enum class WinningLottery(val conditionValue: Int) {
        FIRST(Values.WINNING_CONDITION_FIRST),
        SECOND(Values.WINNING_CONDITION_SECOND),
        THIRD(Values.WINNING_CONDITION_THIRD),
        FOURTH(Values.WINNING_CONDITION_FOURTH),
        FIFTH(Values.WINNING_CONDITION_FIFTH);
    }
}