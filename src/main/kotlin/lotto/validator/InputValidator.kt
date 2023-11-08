package lotto.validator

import lotto.exception.InputException

object InputValidator {

    fun validateInputPurchaseAmount(input: String) {
        checkStringBlank(input)
        checkInteger(input)
    }

    fun validateInputWinningNumbers(input: List<String>) {
        checkStringListBlank(input)
        checkIntegers(input)
    }

    fun validateInputBonusNumber(input: String) {
        checkStringBlank(input)
        checkInteger(input)
    }

    private fun checkStringBlank(input: String) =
        require(input.isNotBlank()) { InputException.STRING_BLANK.message }

    private fun checkInteger(input: String) =
        requireNotNull(input.toIntOrNull()) { InputException.NOT_INTEGER.message }

    private fun checkStringListBlank(input: List<String>) =
        require(input.all { it.isNotBlank() }) { InputException.STRING_BLANK.message }

    private fun checkIntegers(input: List<String>) =
        require(input.all { it.toIntOrNull() != null }) { InputException.NOT_INTEGER.message }
}