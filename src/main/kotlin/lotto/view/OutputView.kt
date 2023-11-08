package lotto.view

import lotto.Constants
import lotto.model.Lottos
import lotto.util.Match

class OutputView {
    fun printBuyingResults(lottos: Lottos) {
        println(BUYING_COUNT_CONFIRMATION.format(lottos.lottoNumbers.size))

        println("${lottos}\n")
    }

    fun printWinningResults(result: Map<Int, Int>) {
        println("$WINNING_STATISTICS\n$DIVIDING_LINE")

        Match.values().forEach { match ->
            println("${match.info} (${match.amount}$MONEY_UNIT) - ${result[match.count] ?: 0}개")
        }
    }

    fun printRateOfReturn(reward: String) {
        println(TOTAL_RATE_OF_RETURN.format(reward))
    }

    fun printError(errorMessage: String) = println("${Constants.ERROR_TAG} $errorMessage")

    companion object {
        private const val BUYING_COUNT_CONFIRMATION = "%d개를 구매했습니다."

        private const val WINNING_STATISTICS = "당첨 통계"
        private const val DIVIDING_LINE = "---"
        private const val MONEY_UNIT = "원"

        private const val TOTAL_RATE_OF_RETURN = "총 수익률은 %s입니다."
    }
}