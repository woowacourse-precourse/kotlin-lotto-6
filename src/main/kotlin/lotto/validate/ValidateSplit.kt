package lotto.validate

import lotto.utils.Messages

class ValidateSplit {
    fun validateSplitMyNumbers(myNumbers: List<String>): List<String> {
        myNumbers.forEach {
            validateInputZero(it)
            validateInputNotNumber(it)
        }
        return myNumbers
    }

    private fun validateInputNotNumber(myNumbers: String) {
        require(myNumbers.all { it.isDigit() }) {"${Messages.ERROR_MESSAGE} ${Messages.INVALID_INPUT}" }
    }

    private fun validateInputZero(myNumbers: String) {
        require(myNumbers.toInt() != 0) { "0은 입력될 수 없습니다." }
    }



}