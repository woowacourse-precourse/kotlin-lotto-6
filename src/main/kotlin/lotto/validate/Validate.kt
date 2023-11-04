package lotto.validate

import lotto.utils.Messages

class Validate {
    fun validateInputPrice(price: String): Int {
        validateInputIsEmpty(price)
        validateInputNotNumber(price)
        validateInputUnderThousands(price.toInt())

        return price.toInt()
    }

    private fun validateInputUnderThousands(price: Int) {
        require(!(price < 1000)) { Messages.VALIDATE_INPUT_UNDER_THOUSAND }
    }

    private fun validateInputNotNumber(x: String) {
        require(x.all { it.isDigit() }) {"${Messages.ERROR_MESSAGE} ${Messages.INVALID_INPUT}" }
    }

    private fun validateInputIsEmpty(x: String) {
        require(x.isNotEmpty()) { Messages.VALIDATE_INPUT_EMPTY }
    }

}