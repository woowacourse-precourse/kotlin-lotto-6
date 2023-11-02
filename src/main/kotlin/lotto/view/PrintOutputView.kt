package lotto.view

import lotto.constant.PrintText
import lotto.domain.Lotto

class PrintOutputView {

    fun printRequirePurchaseAmount() {
        println(PrintText.REQUIRE_PURCHASE_AMOUNT.text)
    }

    fun printPurchaseAmount(purchaseAmount: Int) {
        println()
        println(purchaseAmount.toString() + PrintText.PRINT_PURCHASE_AMOUNT.text)
    }

    fun printRandomWinningNumbers(winningNumbers: List<Lotto>) {
        winningNumbers.forEach { println(it.toLottoNumbersResult()) }
        println()
    }

    fun requireWinningNumber() {
        println(PrintText.REQUIRE_WINNING_NUMBER.text)
    }

    fun requireBonusNumber() {
        println()
        println(PrintText.REQUIRE_BONUS_NUMBER.text)
    }
}