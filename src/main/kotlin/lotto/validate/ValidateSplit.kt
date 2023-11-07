package lotto.validate

import lotto.utils.Constants
import lotto.utils.Messages

class ValidateSplit {
    fun validateSplitMyNumbers(myNumbers: List<String>): List<String> {
        myNumbers.forEach {
            validateInputNotNumber(it)
            validateInputEmpty(it)
        }
        validateDuplicateNumber(myNumbers)
        validateMyNumbersRange(myNumbers)
        return myNumbers
    }

    private fun validateInputNotNumber(myNumbers: String) {
        require(myNumbers.all { it.isDigit() }) { "${Messages.ERROR_MESSAGE} ${Messages.INVALID_INPUT}" }
    }

    private fun validateInputEmpty(myNumbers: String) {
        require(myNumbers.isNotEmpty()) { "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_EMPTY}" }
    }

    private fun validateMyNumbersRange(myNumbers: List<String>) {
        require(myNumbers.all { it.toInt() in Constants.LOTTO_START_NUMBER..Constants.LOTTO_LAST_NUMBER })
        { "${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_OVER_RANGE_MESSAGE}" }
    }

    private fun validateDuplicateNumber(myNumbers: List<String>) {
        require(myNumbers.toSet().size == myNumbers.size) {
            "${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_DUPLICATED_MESSAGE}"
        }
    }


}