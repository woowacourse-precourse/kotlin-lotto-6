package lotto.view

import lotto.constants.askBonusNumberMessage
import lotto.constants.askPurchaseAmountMessage
import lotto.constants.askWinningLottoNumberMessage
import lotto.constants.bonusMessage
import lotto.constants.winningStatisticsDivider
import lotto.constants.winningStatisticsMessage
import lotto.domain.Lotto
import lotto.domain.Rank


class Output {

    private val grossProfitMessage = "총 수익률은 %.1f%%입니다."
    private val hitMessage = "%d개 일치"
    private val prizeMessage = " - (%s원)"
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

    fun printLottos(lottos: ArrayList<Lotto>) {
        lottos.all {
            println(it)
            true
        }
    }

    fun printLottoRankResult(result: Map<Rank, Int>) {
        println(winningStatisticsMessage)
        println(winningStatisticsDivider)
        for (rank in result.keys) {
            printRankMessage(rank, result[rank]!!)
        }
    }

    fun printGrossProfit(profit: Float) {
        println(grossProfitMessage.format(profit))
    }
    private fun printRankMessage(rank: Rank, count:Int){
        val rankMessage =
            if (rank == Rank.SECOND) "${hitMessage(rank.hit)}$bonusMessage"
            else hitMessage(rank.hit)
        println("$rankMessage${prizeMessage(rank.prize)}${hitCountMessage(count)}")
    }
    private fun hitMessage(hit: Int):String {
        return hitMessage.format(hit)
    }
    private fun prizeMessage(prize: Int):String{
        return prizeMessage.format(prize)
    }
    private fun hitCountMessage(count:Int):String{
        return hitCountMessage.format(count)
    }

}