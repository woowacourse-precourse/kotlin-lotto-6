package lotto.validate

import lotto.utils.Constants
import lotto.utils.Messages

class ValidatePrice {
    fun validateInputPrice(price: String): Int {
        validateInputIsEmpty(price)
        validateInputNotNumber(price)
        validateInputUnderThousands(price.toInt())
        validateNoRemainder(price.toInt())

        return price.toInt()
    }

    private fun validateInputUnderThousands(price: Int) {
        require(price >= 1000) { "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_UNDER_THOUSAND}" }
    }

    private fun validateInputNotNumber(price: String) {
        require(price.all { it.isDigit() }) {"${Messages.ERROR_MESSAGE} ${Messages.INVALID_INPUT}" }
    }

    private fun validateInputIsEmpty(price: String) {
        require(price.isNotEmpty()) { "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_EMPTY}" }
    }

    private fun validateNoRemainder(price: Int) {
        require(price % Constants.THOUSAND_PRICE == Constants.ZERO_PRICE)
        { "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_NO_REMINDER}" }
    }
}