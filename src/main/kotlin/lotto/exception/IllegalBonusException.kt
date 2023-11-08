package lotto.exception

import lotto.constants.ErrorConstants

class IllegalBonusException(
    private val errorMessage: String
) : IllegalArgumentException(errorMessage) {

    override val message: String
        get() = "[ERROR] $errorMessage"

    companion object {
        val bonusNotRange = IllegalBonusException(
            errorMessage = ErrorConstants.BONUS_NOT_RANGE
        )
        val bonusDuplicate = IllegalBonusException(
            errorMessage = ErrorConstants.BONUS_DUPLICATE
        )
    }

}