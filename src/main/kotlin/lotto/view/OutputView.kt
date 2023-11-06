package lotto.view

import lotto.Lotto
import lotto.domain.Prize
import lotto.utils.Messages
import lotto.utils.Messages.DIVIDER
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

    fun showLottoNumbers(lottoNumbers: MutableList<Lotto>) {
        for (lottoNumber in lottoNumbers) {
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
        results.forEach { (prize, count) ->
            println("${prize.matchingNumbers}개 일치 (${prize.prizeAmount}원) -  ${count}개")
        }
    }

}