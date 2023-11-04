package lotto.validate

import lotto.utils.Constants
import lotto.utils.Messages

class Validate {
    fun validateInputPrice(price: String): Int {
        validateInputIsEmpty(price)
        validateInputNotNumber(price)
        validateInputUnderThousands(price.toInt())
        validateNoRemainder(price.toInt())

        return price.toInt()
    }

    private fun validateInputUnderThousands(price: Int) {
        require(!(price < 1000)) { "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_UNDER_THOUSAND}" }
    }

    private fun validateInputNotNumber(x: String) {
        require(x.all { it.isDigit() }) {"${Messages.ERROR_MESSAGE} ${Messages.INVALID_INPUT}" }
    }

    private fun validateInputIsEmpty(x: String) {
        require(x.isNotEmpty()) { "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_EMPTY}" }
    }

    private fun validateNoRemainder(price: Int) {
        require(price % Constants.THOUSAND_PRICE == Constants.ZERO_PRICE)
        { "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_NO_REMINDER}" }
    }
}