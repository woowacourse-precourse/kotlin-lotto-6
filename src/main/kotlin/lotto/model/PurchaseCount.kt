package lotto.model

import lotto.constants.Constants.PURCHASE_AMOUNT_UNIT
import lotto.constants.Constants.LOTTO_MAX_COUNT
import lotto.constants.Exception

class PurchaseCount(purchaseAmount: Int) {
    val count = purchaseAmount / PURCHASE_AMOUNT_UNIT.value

    init {
        require(purchaseAmount / PURCHASE_AMOUNT_UNIT.value <= LOTTO_MAX_COUNT.value) {
            Exception.PURCHASE_MAX_COUNT
        }
    }
}