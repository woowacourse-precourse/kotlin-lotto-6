package lotto.view

import lotto.model.Lotto
import lotto.model.WinningRank
import lotto.utils.Constants
import java.text.NumberFormat
import java.util.*

object OutputView {
    fun printCountOfPurchasedLotto(countOfPurchasedLotto: Int) {
        println(Constants.LOTTO_PURCHASED_COUNT_MESSAGE.format(countOfPurchasedLotto))
    }

    fun printLottoes(lottoes: List<Lotto>) {
        lottoes.forEach {
            println(it)
        }
    }

    fun printWinningStatistics(winningStatistic: Map<WinningRank, Int>, earningsRate: Float) {
        println(Constants.WINNING_STATISTICS_INFO_MESSAGE)
        for (winRank in WinningRank.entries) {
            if (winRank == WinningRank.NONE) continue
            val countByWinningRank = winningStatistic.getOrDefault(winRank, 0)
            println(getWinningStatisticsMessage(winRank, countByWinningRank))
        }
        println(Constants.TOTAL_EARNINGS_RATE_MESSAGE.format(earningsRate))
    }

    private fun getWinningStatisticsMessage(winningRank: WinningRank, countByWinningRank: Int): String {
        return if (winningRank == WinningRank.SECOND) {
            Constants.WINNING_STATISTICS_BONUS_MESSAGE
        } else {
            Constants.WINNING_STATISTICS_MESSAGE
        }.format(winningRank.matchCount, winningRank.prizeMoney.formatNumberToString(), countByWinningRank)
    }

    private fun Int.formatNumberToString(): String {
        val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
        return formatter.format(this)
    }
}