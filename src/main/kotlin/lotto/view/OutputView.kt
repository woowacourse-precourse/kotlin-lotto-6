package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult

class OutputView {
    fun printLottosReceipt(lottos: List<Lotto>) {
        printBlankLine()
        println("${lottos.size}" + PURCHASE_LOTTOS_MESSAGE)
        printLottoNumbers(lottos)
    }

    private fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            println(lotto)
        }
        printBlankLine()
    }

    fun printWinningStatistics(lottoResult: LottoResult) {
        printBlankLine()
        println(WINNING_RESULT)
        println(LINE)
        print(lottoResult)
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        print(RATE_OF_RETURN_MESSAGE.format(rateOfReturn))
    }

    private fun printBlankLine() {
        println()
    }

    companion object {
        private const val PURCHASE_LOTTOS_MESSAGE = "개를 구매했습니다."
        private const val RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다."
        private const val WINNING_RESULT = "당첨 통계"
        private const val LINE = "---"
    }
}