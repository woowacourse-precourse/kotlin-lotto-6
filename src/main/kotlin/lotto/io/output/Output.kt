package lotto.io.output

import lotto.constants.Print
import lotto.constants.WinningResult
import lotto.convertWithRound
import lotto.model.Lottos

class Output {
    fun printInputAmount() = println(Print.INPUT_AMOUNT)

    fun printPurchaseCount(purchaseCount: Int) {
        lineBreak()
        println(Print.PURCHASE_COUNT.format(purchaseCount))
    }

    fun printLottos(lottos: Lottos) {
        lottos.forEach { lotto -> println(lotto) }
        lineBreak()
    }

    fun printInputWinningNumbers() = println(Print.INPUT_WINNING_NUMBERS)

    fun printInputBonusNumbers() {
        lineBreak()
        println(Print.INPUT_BONUS_NUMBERS)
    }

    fun printWinningStat(winningCounts: Map<WinningResult, Int>, totalReturn: Double) {
        lineBreak()
        println(Print.WINNING_STAT)
        println(Print.DIVIDE_LINE)

        printWinningSituation(winningCounts)
        printTotalReturn(totalReturn)
    }

    private fun printWinningSituation(winningCounts: Map<WinningResult, Int>) {
        winningCounts.forEach { result ->
            val winningResult = result.key
            val winningCount = result.value
            val bonusMessage = run {
                if (winningResult == WinningResult.FIVE_BONUS) {
                    Print.BONUS
                } else ""
            }

            println(Print.MATCHING_NUMBER.format(
                winningResult.matchingCount,
                bonusMessage,
                winningResult.amount,winningCount))
        }
    }

    private fun printTotalReturn(totalReturn: Double) {
        val totalReturnRound = totalReturn.convertWithRound()
        println(Print.TOTAL_RETURN.format(totalReturnRound))
    }

    private fun Print.format(vararg args: Any) = this.toString().format(args)

    private fun lineBreak() = println()
}