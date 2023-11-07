package lotto.model

import lotto.util.Constants.LOTTO_PRICE
import lotto.util.Validator.validate1000Unit
import lotto.util.Validator.validateRange

class Purchase(private val _price: Int) {
    private var _count = 0
    val count: Int
        get() = _count

    val price: Int
        get() = _price

    init {
        validateRange(_price)
        validate1000Unit(_price)
        _count = _price / LOTTO_PRICE
    }
}