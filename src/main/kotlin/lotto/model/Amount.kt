package lotto.model

import lotto.constants.Constants.PURCHASE_AMOUNT_UNIT
import lotto.constants.Exception

class Amount(private val amount: Int) {
    init {
        require(amount % PURCHASE_AMOUNT_UNIT.value == 0) { Exception.DIVISIBLE }
    }

    fun getPurchaseCount() = amount / PURCHASE_AMOUNT_UNIT.value
}