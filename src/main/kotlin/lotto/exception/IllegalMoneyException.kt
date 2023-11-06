package lotto.exception

import lotto.constants.ErrorConstants

class IllegalMoneyException(
    private val errorMessage: String
) : IllegalArgumentException(errorMessage) {

    override val message: String
        get() = "[ERROR] $errorMessage"

    companion object {
        val moneyNotNumber = IllegalMoneyException(
            errorMessage = ErrorConstants.MONEY_NOT_NUMBER
        )
        val moneyTooMuch = IllegalMoneyException(
            errorMessage = ErrorConstants.MONEY_TOO_MUCH
        )
        val moneyUnderPrice = IllegalMoneyException(
            errorMessage = ErrorConstants.MONEY_UNDER_PRICE
        )
        val moneyNotDivide = IllegalMoneyException(
            errorMessage = ErrorConstants.MONEY_NOT_DIVIDE
        )
    }
}