package lotto.view

import lotto.constant.PrintText

class PrintOutputView {

    fun printRequirePurchaseAmount() {
        println(PrintText.REQUIRE_PURCHASE_AMOUNT.text)
    }

    fun printPurchaseAmount(purchaseAmount: Int) {
        println(purchaseAmount.toString() + PrintText.PRINT_PURCHASE_AMOUNT.text)
    }

    fun requireWinnerNumber() {
        println(PrintText.REQUIRE_WINNING_NUMBER.text)
    }

    fun requireBonusNumber() {
        println(PrintText.REQUIRE_BONUS_NUMBER.text)
    }
}