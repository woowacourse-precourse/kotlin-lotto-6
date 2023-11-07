package lotto.view

import lotto.Lotto
import lotto.domain.Prize
import lotto.utils.Messages
import lotto.utils.Messages.DIVIDER
import lotto.utils.Messages.PROFIT_MESSAGE
import lotto.utils.Messages.WINNING_STATISTICS_MESSAGE

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
            println("${it.message} (${it.prizeAmount}원) - ${results[it]}개")
        }
    }


    fun printProfitPercentage(profitPercentage: Double) {
        println(String.format(PROFIT_MESSAGE, profitPercentage))
    }

}
