package utils

import lotto.LottoMachine.Companion.WON_PER_LOTTO

class LottoPurchaseValidator : IntegerInputValidator() {

    fun checkInputValidation(input: String): Boolean {
        super.validateIsString(input)
        super.validateIsNegative(input)
        super.validateIsZero(input)
        validateInvalidPurchaseAmount(input)
        return true
    }

    fun validateInvalidPurchaseAmount(input: String) {
        require(((input.toInt()) % WON_PER_LOTTO) == 0) { getInvalidAmountErrMsg() }
    }
}