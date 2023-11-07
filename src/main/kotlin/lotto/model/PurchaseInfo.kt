package lotto.model

import lotto.constants.Constants
import lotto.constants.Constants.PURCHASE_AMOUNT_UNIT
import lotto.constants.Exception

class PurchaseInfo(val amount: Int) {
    val count = amount / PURCHASE_AMOUNT_UNIT.value

    init {
        require(amount % PURCHASE_AMOUNT_UNIT.value == 0) { Exception.PURCHASE_DIVISIBLE }
    }
}