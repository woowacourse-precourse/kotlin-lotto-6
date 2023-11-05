package lotto.io.output

import lotto.constants.Print
import lotto.constants.WinningRank
import lotto.utils.convertWithRound
import lotto.model.lotto.PurchaseLottos
import lotto.model.WinningCounts

class Output {
    fun printInputPurchaseAmount() = println(Print.INPUT_PURCHASE_AMOUNT)

    fun printPurchaseCount(purchaseCount: Int) {
        lineBreak()
        println(Print.PURCHASE_COUNT.toString().format(purchaseCount))
    }

    fun printLottos(purchaseLottos: PurchaseLottos) {
        purchaseLottos.forEach { lotto -> println(lotto) }
        lineBreak()
    }

    fun printInputWinningNumbers() = println(Print.INPUT_WINNING_NUMBERS)

    fun printInputBonusNumber() {
        lineBreak()
        println(Print.INPUT_BONUS_NUMBERS)
    }

    fun printWinningStat(winningCounts: WinningCounts, totalReturn: Double) {
        lineBreak()
        println(Print.WINNING_STAT)
        println(Print.DIVIDE_LINE)

        printWinningCounts(winningCounts)
        printTotalReturn(totalReturn)
    }

    private fun printWinningCounts(winningCounts: WinningCounts) {
        WinningRank.entries.forEach { winningRank ->
            if (winningRank == WinningRank.NOT_WINNING) {
                return@forEach
            }

            println(Print.MATCHING_NUMBER.toString().format(
                winningRank.toString(), winningCounts[winningRank]))
        }
    }

    private fun printTotalReturn(totalReturn: Double) {
        val totalReturnRound = totalReturn.convertWithRound()
        println(Print.TOTAL_RETURN.toString().format(totalReturnRound))
    }

    private fun lineBreak() = println()
}