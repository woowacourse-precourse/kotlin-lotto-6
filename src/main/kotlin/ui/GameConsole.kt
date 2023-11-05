package ui

import lotto.Lotto
import lotto.WinningCriteria

class GameConsole {
    fun showLottoTickets(lottoTickets: List<Lotto>, count: Int) {
        println("\n$count" + PURCHASE_RESULT_MSG)
        for (lotto in lottoTickets) {
            println(lotto)
        }
    }

    fun showWinningStatistic(results: Map<WinningCriteria, Int>) {
        println(WINNING_STATISTIC_RESULT_MSG)
        val sortedResults = results.toList().sortedBy { it.first.prize }
        sortedResults.forEach { (winningResult, count) ->
            printWinningStatistic(winningResult, count)
        }
    }

    private fun printWinningStatistic(winningResult: WinningCriteria, count: Int) {
        when (winningResult) {
            WinningCriteria.SECOND -> {
                print("${winningResult.matchingNumbers}개 일치, 보너스 볼 일치 ")
            }

            else -> {
                print("${winningResult.matchingNumbers}개 일치 ")
            }
        }
        println("(${String.format("%,d", winningResult.prize)}원) - ${count}개")
    }

    companion object {
        const val PURCHASE_RESULT_MSG = "개를 구매했습니다."
        const val WINNING_STATISTIC_RESULT_MSG = "\n당첨 통계" + "\n---"
    }
}