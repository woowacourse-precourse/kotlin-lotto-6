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
            println("3개 일치 (5,000원) - ${results[Prize.THREE_MATCH] ?: 0}개")
            println("4개 일치 (50,000원) - ${results[Prize.FOUR_MATCH] ?: 0}개")
            println("5개 일치 (1,500,000원) - ${results[Prize.FIVE_MATCH] ?: 0}개")
            println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${results[Prize.FIVE_MATCH_WITH_BONUS] ?: 0}개")
            println("6개 일치 (2,000,000,000원) - ${results[Prize.SIX_MATCH] ?: 0}개")
        }

    }
