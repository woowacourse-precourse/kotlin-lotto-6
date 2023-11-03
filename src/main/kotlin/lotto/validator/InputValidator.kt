package lotto.validator

import lotto.exception.InputException

object InputValidator {

    fun validateInputPurchaseAmount(input: String) {
        checkStringBlank(input)
        checkInteger(input)
    }

    private fun checkStringBlank(input: String) =
        require(input.isNotBlank()) { InputException.STRING_BLANK.message }

    private fun checkInteger(input: String) =
        requireNotNull(input.toIntOrNull()) { InputException.NOT_INTEGER.message }
}