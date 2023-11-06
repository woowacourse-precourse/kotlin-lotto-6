package model

import util.InputValidation

class Money(private val price: String) {
    init {
        InputValidation.ONLY_NUMBER.isValid(price)
        InputValidation.NUMBER_EMPTY.isValid(price)
        InputValidation.NUMBER_FORMAT.isValid(price)
        InputValidation.VALID_RANGE.isValid(price)
        InputValidation.PURCHASE_IN_THOUSAND_WON.isValid(price)
    }

    fun getPurchasableLottoTicketCount() = price.toInt() / 1000
}
