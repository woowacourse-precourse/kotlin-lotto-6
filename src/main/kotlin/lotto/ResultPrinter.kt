package lotto

import lotto.GameMessageConstants.countResultMessage
import lotto.GameMessageConstants.totalReturnRateMessage

class ResultPrinter(
    private val printer: Printer
) {
    fun printResults(results: LottoResult, money: Int) {
        printRank(results)
        printRate(results, money)
    }

    private fun printRank(results: LottoResult) {
        Rank.values().forEach { rank ->
            printer.show(countResultMessage(rank, results))
        }
    }

    private fun printRate(results: LottoResult, money: Int) {
        val earningRate = results.totalPrize / money * PERCENTAGE_MULTIPLIER
        printer.show(totalReturnRateMessage(earningRate))
    }

    companion object {
        private const val PERCENTAGE_MULTIPLIER = 100
    }
}
