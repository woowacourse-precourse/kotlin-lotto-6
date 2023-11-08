package lotto.model

import lotto.util.GameConstants.LOTTO_PRICE
import lotto.util.GameConstants.ZERO
import lotto.util.Validator.validateUnit

class Purchase(private val _price: Int) {
    private var _count = ZERO

    val price: Int
        get() = _price

    val count: Int
        get() = _count

    init {
        validateUnit(_price)
        _count = _price / LOTTO_PRICE
    }
}