package lotto.domain

import lotto.validator.PurchasePriceValidator

class LottoStore(private val value: String) {
    init {
        PurchasePriceValidator(value)
    }
    fun getNumberOfTickets(): Int {
        return value.toInt() / 1000
    }
}
