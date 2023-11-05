package lotto.model

import lotto.constants.Constants.PURCHASE_AMOUNT_UNIT
import lotto.constants.Constants.LOTTO_MAX_COUNT
import lotto.constants.Exception

class Amount(private val amount: Int) {
    init {
        require(amount % PURCHASE_AMOUNT_UNIT.value == 0) { Exception.DIVISIBLE }
        require(amount / PURCHASE_AMOUNT_UNIT.value >= LOTTO_MAX_COUNT.value) { Exception.MAX_COUNT }
    }

    fun getPurchaseCount() = amount / PURCHASE_AMOUNT_UNIT.value

}