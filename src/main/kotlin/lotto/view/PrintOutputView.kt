package lotto.view

import lotto.constant.PrintText

class PrintOutputView {

    fun printRequirePurchaseAmount() {
        println(PrintText.REQUIRE_PURCHASE_AMOUNT)
    }

    fun printPurchaseAmount(purchaseAmount: Int) {
        println(purchaseAmount.toString()+ PrintText.PRINT_PURCHASE_AMOUNT)
    }
}