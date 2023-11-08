package lotto.view

import lotto.constants.GuideMessage.SHOW_WINNING_STATISTICS
import lotto.constants.GuideMessage.SHOW_TOTAL_PROFIT_RATE
import lotto.constants.Lotto.RANK_COUNT
import lotto.domain.LottoRank

object WinningStatisticsView {
  fun printWinningsStatistics() {
    println(SHOW_WINNING_STATISTICS)
    for (rank in LottoRank.entries) {
      println(rank.message + RANK_COUNT.format(rank.count))
    }
  }

  fun printTotalProfitRate(totalProfitRate: Double) {
    println(SHOW_TOTAL_PROFIT_RATE.format(totalProfitRate))
  }
}