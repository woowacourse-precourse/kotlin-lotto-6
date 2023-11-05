package model

import util.Validator.containsOnlyDigits
import util.Validator.isAmountInThousandWon
import util.Validator.isAmountOverMaxLimit
import util.Validator.isEmptyValue
import util.Validator.isValidNumberFormat

class Money(private val price: String) {
    init {
        containsOnlyDigits(price)
        isEmptyValue(price)
        isValidNumberFormat(price)
        isAmountInThousandWon(price)
        isAmountOverMaxLimit(price)
    }

    fun getPurchasableLottoTicketCount() = price.toInt() / 1000
}
