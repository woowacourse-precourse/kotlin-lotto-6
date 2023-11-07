package lotto.view

import lotto.Lotto
import lotto.constants.Constants
import lotto.domain.Stats

class OutputView {

    fun printBuyLottos(buyLottos: List<Lotto>) {
        buyLottos.forEach{ lotto ->
            println(lotto)
        }
    }

    fun printLottoStats(lottoStats: Map<Stats, Int>) {
        println(Constants.WINNING_STATS)
        for (lottoStat in lottoStats.filterNot { lottoStat -> lottoStat.key.name == Stats.NONE.name }) {
            println(PRINT_LOTTO_STATS_MESSAGE
                .format(lottoStat.key.correctNumberCount, lottoStat.key.winningMessage, lottoStat.value))
        }
    }

    fun printEarningRate(lottoStats: Map<Stats, Int>, buyAmount: Int) {
        println(PRINT_EARNING_RATE_MESSAGE.format(getEarningRate(lottoStats, buyAmount)))
    }

    fun getEarningRate(lottoStats: Map<Stats, Int>, buyAmount: Int) : Double {
        val totalPrize = getTotalPrize(lottoStats).toDouble()
        println("totalPrize $totalPrize buyAmount $buyAmount")
        return totalPrize / (buyAmount * LOTTO_PRICE) * DIVIDE_NUMBER_RATE
    }

    fun getTotalPrize(lottoStats: Map<Stats, Int>) : Int{
        var totalPrize = INITIAL_TOTAL_PRIZE
        for (lotto in lottoStats) {
            totalPrize += lotto.key.winningPrize * lotto.value
        }
        return totalPrize
    }

    companion object {
        const val PRINT_LOTTO_STATS_MESSAGE = "%d개 일치%s %d개"
        const val PRINT_EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다."
        const val DIVIDE_NUMBER_RATE = 100
        const val INITIAL_TOTAL_PRIZE = 0
        const val LOTTO_PRICE = 1000
    }

}