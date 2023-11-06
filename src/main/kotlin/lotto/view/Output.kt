package lotto.view

import lotto.constants.askBonusNumberMessage
import lotto.constants.askPurchaseAmountMessage
import lotto.constants.askWinningLottoNumberMessage
import lotto.constants.bonusMessage
import lotto.constants.winningStatisticsDivider
import lotto.constants.winningStatisticsMessage
import lotto.domain.Lottos
import lotto.domain.Rank
import java.text.NumberFormat
import java.util.Locale


class Output {
    private val lottoAmountMessage = "%d개를 구매했습니다."
    private val grossProfitMessage = "총 수익률은 %.1f%%입니다."
    private val hitMessage = "%d개 일치"
    private val prizeMessage = " (%s원)"
    private val hitCountMessage = " - %d개"
    fun askPurchaseAmount() {
        println(askPurchaseAmountMessage)
    }

    fun askWinningLottoNumber() {
        println(askWinningLottoNumberMessage)
    }

    fun askBonusNumber() {
        println(askBonusNumberMessage)
    }

    fun printLottos(lottos: Lottos) {
        println(lottoAmountMessage.format(lottos.getLottos().size))
        for (lotto in lottos.getLottos()) {
            println(lotto.toString())
        }
    }

    fun printLottoRankResult(result: Map<Rank, Int>) {
        println(winningStatisticsMessage)
        println(winningStatisticsDivider)
        for (rank in result.keys) {
            if (rank != Rank.NOTHING) {
                printRankMessage(rank, result[rank]!!)
            }
        }
    }

    fun purchaseAmount(ticketCount: Int): Int {
        return ticketCount * 1000
    }

    fun printGrossProfit(profit: Double) {
        println(grossProfitMessage.format(profit))
    }

    private fun printRankMessage(rank: Rank, count: Int) {
        val rankMessage =
            if (rank == Rank.SECOND) "${hitMessage(rank.hit)}$bonusMessage"
            else hitMessage(rank.hit)
        println("$rankMessage${prizeMessage(rank.prize)}${hitCountMessage(count)}")
    }

    private fun hitMessage(hit: Int): String {
        return hitMessage.format(hit)
    }

    private fun prizeMessage(prize: Int): String {
        val formatter = NumberFormat.getNumberInstance(Locale("en", "US"))
        return prizeMessage.format(formatter.format(prize))
    }

    private fun hitCountMessage(count: Int): String {
        return hitCountMessage.format(count)
    }
}