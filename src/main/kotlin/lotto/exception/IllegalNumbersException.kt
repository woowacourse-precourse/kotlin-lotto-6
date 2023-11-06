package lotto.exception

import lotto.constants.ErrorConstants

class IllegalNumbersException(
    private val errorMessage: String
) : IllegalArgumentException(errorMessage) {

    override val message: String
        get() = "[ERROR] $errorMessage"

    companion object {
        val numbersNotList = IllegalNumbersException(
            errorMessage = ErrorConstants.NUMBERS_NOT_LIST
        )
        val numbersNotRange = IllegalNumbersException(
            errorMessage = ErrorConstants.NUMBERS_NOT_RANGE
        )
        val numbersDuplicate = IllegalNumbersException(
            errorMessage = ErrorConstants.NUMBERS_DUPLICATE
        )
    }

}