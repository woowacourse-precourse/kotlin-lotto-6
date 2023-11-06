package lotto.domain

import lotto.constants.*
import lotto.ui.Input

class PurchaseLotto {
    init {
        println(MESSAGE_PURCHASE_AMOUNT)
    }

    fun inputAmount(): Int {
        val amount = Input.inputPurchaseAmount()
        validateAmount(amount)
        return amount.toInt()
    }
}