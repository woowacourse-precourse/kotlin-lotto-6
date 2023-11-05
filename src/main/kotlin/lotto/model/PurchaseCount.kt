package lotto.model

import lotto.util.Constants.LOTTO_PRICE
import lotto.util.Validator.validate1000Unit
import lotto.util.Validator.validateRange

class PurchaseCount(private val purchase: Int) {
    private var _count = 0
    val count: Int
        get() = _count

    init {
        validateRange(purchase)
        validate1000Unit(purchase)
        _count = purchase / LOTTO_PRICE
    }
}