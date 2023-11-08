package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoResult

class OutputManager {
    fun printInputMoneyPrompt() {
        println(INPUT_MONEY_PROMPT_MESSAGE)
    }

    fun printWinningNumbersPrompt() {
        println(WINNING_NUMBERS_PROMPT_MESSAGE)
    }

    fun printBonusNumberPrompt() {
        printBlankLine()
        println(BONUS_NUMBER_PROMPT_MESSAGE)
    }

    fun printLottosReceipt(lottos: List<Lotto>) {
        printNumberOfLottos(lottos)
        printLottoNumbers(lottos)
    }

    private fun printNumberOfLottos(lottos: List<Lotto>) {
        printBlankLine()
        println("${lottos.size}" + PURCHASE_LOTTOS_MESSAGE)
    }

    private fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            println(lotto)
        }
        printBlankLine()
    }

    fun printWinningStatistics(result: LottoResult) {
        printBlankLine()
        println(WINNING_RESULT)
        println(LINE)
        print(result)
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        print(RATE_OF_RETURN_MESSAGE.format(rateOfReturn))
    }

    private fun printBlankLine() {
        println()
    }

    companion object {
        private const val INPUT_MONEY_PROMPT_MESSAGE = "구입금액을 입력해 주세요."
        private const val WINNING_NUMBERS_PROMPT_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val BONUS_NUMBER_PROMPT_MESSAGE = "보너스 번호를 입력해 주세요."

        private const val PURCHASE_LOTTOS_MESSAGE = "개를 구매했습니다."
        private const val RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다."
        private const val WINNING_RESULT = "당첨 통계"
        private const val LINE = "---"
    }
}