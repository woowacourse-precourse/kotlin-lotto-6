package lotto.exception

import lotto.constants.ErrorConstants

class IllegalBonusException (
    private val errorMessage: String
) : IllegalArgumentException(errorMessage) {

    override val message: String
        get() = "[ERROR] $errorMessage"

    companion object {
        val bonusNotNumber = IllegalNumbersException(
            errorMessage = ErrorConstants.BONUS_NOT_NUMBER
        )
    }

}