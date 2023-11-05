package lotto.model

import lotto.constants.Constants.PURCHASE_AMOUNT_UNIT
import lotto.constants.Constants.LOTTO_MAX_COUNT
import lotto.constants.Exception

class PurchaseAmount(val amount: Int) {
    init {
        require(amount % PURCHASE_AMOUNT_UNIT.value == 0) { Exception.DIVISIBLE }
    }
}