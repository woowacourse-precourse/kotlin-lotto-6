package lotto.model

import lotto.util.Validator.validate1000Unit
import lotto.util.Validator.validateInteger
import lotto.util.Validator.validateNotNull
import lotto.util.Validator.validateRange

class PurchaseCount(private val purchase: String) {
    private var _count = 0
    val count: Int
        get() = _count

    init {
        validateNotNull(purchase)
        validateInteger(purchase)
        validateRange(purchase)
        validate1000Unit(purchase)
        _count = purchase.toInt() / 1000
    }
}