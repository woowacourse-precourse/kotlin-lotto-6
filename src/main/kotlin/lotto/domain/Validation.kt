package lotto.domain

import lotto.presentation.LottoPurchaseView
import lotto.util.EXCEPTION_MESSAGE
import lotto.util.WRONG_NUMBER_EXCEPTION
import lotto.util.WRONG_RANGE_NEGATIVE_EXCEPTION
import lotto.util.WRONG_UNIT_EXCEPTION

class Validation {
    fun validationAmount(amount: String): Int {
        validationType(amount)
        validationNegative(amount)
        validationUnit(amount)
        return amount.toInt()
    }

    private fun validationType(amount: String): Int {
        try {
            lotto.util.Exception.validateTypeException(amount)
        } catch (e: Exception) {
            println(EXCEPTION_MESSAGE + WRONG_NUMBER_EXCEPTION)
            Validation().validationAmount(LottoPurchaseView.inputLottoPurchase())
        }
        return amount.toInt()
    }

    private fun validationNegative(amount: String): Int {
        try {
            lotto.util.Exception.validateNegativeException(amount.toInt())
        } catch (e: Exception) {
            println(EXCEPTION_MESSAGE + WRONG_RANGE_NEGATIVE_EXCEPTION)
            Validation().validationAmount(LottoPurchaseView.inputLottoPurchase())
        }
        return amount.toInt()
    }

    private fun validationUnit(amount: String): Int {
        try {
            lotto.util.Exception.validateUnitException(amount.toInt())
        } catch (e: Exception) {
            println(EXCEPTION_MESSAGE + WRONG_UNIT_EXCEPTION)
            Validation().validationAmount(LottoPurchaseView.inputLottoPurchase())
        }
        return amount.toInt()
    }
}