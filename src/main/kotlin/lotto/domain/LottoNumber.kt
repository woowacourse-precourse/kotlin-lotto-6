package lotto.domain

import lotto.constants.ErrorConstants
import lotto.constants.GameConstants.MAX_NUMBER
import lotto.constants.GameConstants.MIN_NUMBER

class LottoNumber(numberAsString: String) {
    val number: Int = parseNumber(numberAsString)

    companion object {
        private fun parseNumber(numberAsString: String): Int {
            val number = numberAsString.toIntOrNull()
                ?: throw IllegalArgumentException(ErrorConstants.INPUT_ERROR_MESSAGE)

            validateNumberRange(number)

            return number
        }

        private fun validateNumberRange(number: Int) {
            require(number in MIN_NUMBER..MAX_NUMBER) {
                ErrorConstants.RANGE_ERROR_MESSAGE
            }
        }
    }
}
