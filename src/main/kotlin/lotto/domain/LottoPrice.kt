package lotto.domain

import lotto.validator.PurchasePriceValidator

class LottoPrice(private val value: Int) {
    init {
        PurchasePriceValidator()
    }

    fun getNumberOfTickets(): Int {
        return value / 1000
    }
}
