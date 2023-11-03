package lotto.io.output

import lotto.constants.Print
import lotto.constants.WinningResult
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

    private fun Print.format(vararg args: Any) = this.toString().format(args)

    private fun lineBreak() = println()
}