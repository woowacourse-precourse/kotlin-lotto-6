package lotto.validate

import lotto.utils.Messages

class ValidateNumbers {
    fun validateInputMyNumbers(myNumbers: String): String {
        validateInputIsEmpty(myNumbers)
        return myNumbers
    }

    private fun validateInputIsEmpty(myNumbers: String) {
        require(myNumbers.isNotEmpty()) { "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_EMPTY}" }
    }
}