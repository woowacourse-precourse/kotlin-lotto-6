package lotto.validate

import lotto.utils.Constants
import lotto.utils.Messages

class ValidateBonus {
    fun validateBonus(bonusNumber: String) {
        validateInputIsEmpty(bonusNumber)
        validateInputNotNumber(bonusNumber)
        validateMyNumbersRange(bonusNumber.toInt())
    }

    private fun validateInputIsEmpty(bonusNumber: String) {
        require(bonusNumber.isNotEmpty()) {
            "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_EMPTY}"
        }
    }

    private fun validateInputNotNumber(bonusNumber: String) {
        require(bonusNumber.all { it.isDigit() }) {"${Messages.ERROR_MESSAGE} ${Messages.INVALID_INPUT}" }
    }

    private fun validateMyNumbersRange(bonusNumber: Int) {
        require(bonusNumber in Constants.LOTTO_START_NUMBER..Constants.LOTTO_LAST_NUMBER)
        { "${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_OVER_RANGE_MESSAGE}" }
    }
}