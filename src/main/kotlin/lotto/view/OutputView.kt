package lotto.view

import lotto.model.Lotto
import lotto.model.Prize
import lotto.utils.Messages
import lotto.utils.Messages.DIVIDER
import lotto.utils.Messages.WINNING_STATISTICS_MESSAGE
import lotto.utils.StringConverter.formatNumberWithComma
import lotto.utils.StringConverter.formatPercentage

object OutputView {
    fun showInputBuyPriceMessage() {
        println(Messages.BUY_PRICE_MESSAGE)
    }

    fun showInputMyNumbersMessage() {
        println(Messages.INPUT_MY_NUMBERS_MESSAGE)
    }

    fun showBuyTicketMessage(ticket: Int) {
        println("$ticket${Messages.BUY_TICKET_MESSAGE}")
    }

    fun showLottoNumbers(answerLottoNumbers: MutableList<Lotto>) {
        for (lottoNumber in answerLottoNumbers) {
            println(lottoNumber)
        }
    }

    fun showInputBonusNumberMessage() {
        println(Messages.BONUS_NUMBER_MESSAGE)
    }

    fun showWinningStatisticsMessages() {
        println(WINNING_STATISTICS_MESSAGE)
        println(DIVIDER)
    }

    fun printResults(results: MutableMap<Prize, Int>) {
        Prize.entries.forEach {
            println("${it.message} (${formatNumberWithComma(it.prizeAmount)}원) - ${results[it]}개")
        }
    }

    fun printProfitPercentage(profitPercentage: Double) {
        println(formatPercentage(profitPercentage))
    }

}
