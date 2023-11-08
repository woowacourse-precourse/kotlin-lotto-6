package lotto.view

import lotto.model.Prize
import lotto.model.Ranking
import lotto.model.Ticket
import lotto.util.GameConstants.BONUS_MESSAGE
import lotto.util.GameConstants.COUNT_MESSAGE
import lotto.util.GameConstants.DIVIDER_MESSAGE
import lotto.util.GameConstants.INDEX_1ST
import lotto.util.GameConstants.INDEX_2ND
import lotto.util.GameConstants.INDEX_3RD
import lotto.util.GameConstants.INDEX_4TH
import lotto.util.GameConstants.INDEX_5TH
import lotto.util.GameConstants.NUMBER_MESSAGE
import lotto.util.GameConstants.PRICE_MESSAGE
import lotto.util.GameConstants.RANK_1ST
import lotto.util.GameConstants.RANK_2ND
import lotto.util.GameConstants.RANK_3RD
import lotto.util.GameConstants.RANK_4TH
import lotto.util.GameConstants.RANK_5TH
import lotto.util.GameConstants.STATISTICS_MESSAGE

class OutputView {
    fun printPriceMessage() {
        println(PRICE_MESSAGE)
    }

    fun printPurchaseCountMessage(count: Int) {
        println()
        println("${count}${COUNT_MESSAGE}")
    }

    fun printTicket(ticket: Ticket) {
        ticket.tickets.forEach {
            println(it)
        }
    }

    fun printWinningNumberMessage() {
        println()
        println(NUMBER_MESSAGE)
    }

    fun printBonusMessage() {
        println()
        println(BONUS_MESSAGE)
    }

    fun printStatistics(ranking: Ranking) {
        val rankings = ranking.rank
        println()
        println(STATISTICS_MESSAGE)
        println(DIVIDER_MESSAGE)
        println("${RANK_5TH}${rankings[INDEX_5TH]}개")
        println("${RANK_4TH}${rankings[INDEX_4TH]}개")
        println("${RANK_3RD}${rankings[INDEX_3RD]}개")
        println("${RANK_2ND}${rankings[INDEX_2ND]}개")
        println("${RANK_1ST}${rankings[INDEX_1ST]}개")
    }

    fun printRate(prize: Prize) {
        println("총 수익률은 ${prize.rate}%입니다.")
    }
}