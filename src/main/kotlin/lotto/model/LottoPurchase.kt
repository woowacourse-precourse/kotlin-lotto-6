package lotto.model

import lotto.util.Validator

class LottoPurchase(private val purchase: String) {
    private var _count = 0
    val count: Int
        get() = _count
    
    init {
        Validator.validateInteger(purchase)
        Validator.validateRange(purchase)
        Validator.validate1000Unit(purchase)
    }
}