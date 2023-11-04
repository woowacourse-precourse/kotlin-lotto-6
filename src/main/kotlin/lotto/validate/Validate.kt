package lotto.validate

import lotto.utils.Messages

class Validate {
    fun validateInputPrice(price: String): Int {
        validateInputIsEmpty(price)
        return price.toInt()
    }

    private fun validateInputIsEmpty(x: String) {
        require(x.isNotEmpty()) { Messages.VALIDATE_INPUT_EMPTY }
    }

}