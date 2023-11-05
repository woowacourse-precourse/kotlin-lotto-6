package lotto.validate

import lotto.utils.Constants
import lotto.utils.Messages

class ValidateSplit {
    fun validateSplitMyNumbers(myNumbers: List<String>): List<String> {
        myNumbers.forEach {
            validateInputZero(it)
            validateInputNotNumber(it)
        }
        validateDuplicateBonusNumber(myNumbers)
        validateMyNumbersRange(myNumbers)
        return myNumbers
    }

    private fun validateInputNotNumber(myNumbers: String) {
        require(myNumbers.all { it.isDigit() }) { "${Messages.ERROR_MESSAGE} ${Messages.INVALID_INPUT}" }
    }

    private fun validateInputZero(myNumbers: String) {
        require(myNumbers.toInt() != 0) { "0은 입력될 수 없습니다." }
    }

    private fun validateMyNumbersRange(x: List<String>) {
        require(x.all { it.toInt() in Constants.LOTTO_START_NUMBER..Constants.LOTTO_LAST_NUMBER })
        { "${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_OVER_RANGE_MESSAGE}" }
    }

    private fun validateDuplicateBonusNumber(x: List<String>) {
        require(x.toSet().size == x.size) {
            "${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_DUPLICATED_MESSAGE}"
        }
    }

}