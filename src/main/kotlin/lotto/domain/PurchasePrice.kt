package lotto.domain

import lotto.constant.ErrorMessage

class PurchasePrice(private val price: Int) {

    init {
        require(
            price >= MIN_PURCHASE_AMOUNT && price % MIN_PURCHASE_AMOUNT == PURCHASE_AMOUNT_CHANGES
        ) { ErrorMessage.NOT_PURCHASE_AMOUNT_FORMAT.message }
    }

    fun calculateLottoCount() = price / LOTTO_PRICE
    fun getPurchasePrice() = price


    companion object {
        private const val MIN_PURCHASE_AMOUNT = 1000
        private const val PURCHASE_AMOUNT_CHANGES = 0
        private const val LOTTO_PRICE = 1000
    }
}