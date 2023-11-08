package lotto.domain

import lotto.presentation.LottoDecisionView.inputBonusNumber
import lotto.presentation.LottoDecisionView.inputWinningNumber
import lotto.presentation.LottoPurchaseView
import lotto.util.DUPLICATE_NUMBER_EXCEPTION
import lotto.util.DUPLYCATE_BONUS_EXCEPTION
import lotto.util.EXCEPTION_MESSAGE
import lotto.util.Exception.validationBonusCountException
import lotto.util.Exception.validationBonusDuplicationException
import lotto.util.Exception.validationDuplicationException
import lotto.util.Exception.validationRangeException
import lotto.util.Exception.validationSeparatorException
import lotto.util.WRONG_BONUS_COUNT_EXCEPTION
import lotto.util.WRONG_NUMBER_EXCEPTION
import lotto.util.WRONG_RANGE_EXCEPTION
import lotto.util.WRONG_RANGE_NEGATIVE_EXCEPTION
import lotto.util.WRONG_SEPARATOR
import lotto.util.WRONG_UNIT_EXCEPTION

class Validation {
    fun validationAmount(amount: String): Int {
        validationType(amount)
        validationNegative(amount)
        validationUnit(amount)
        return amount.toInt()
    }

    fun validationLotto(lotto: List<Int>): List<Int> {
        validationRange(lotto)
        validationDuplication(lotto)
        return lotto
    }

    private fun validationType(amount: String): Int {
        try {
            lotto.util.Exception.validateTypeException(amount)
        } catch (e: IllegalArgumentException) {
            println(EXCEPTION_MESSAGE + WRONG_NUMBER_EXCEPTION)
            Validation().validationAmount(LottoPurchaseView.inputLottoPurchase())
        }
        return amount.toInt()
    }

    private fun validationNegative(amount: String): Int {
        try {
            lotto.util.Exception.validateNegativeException(amount.toInt())
        } catch (e: IllegalArgumentException) {
            println(EXCEPTION_MESSAGE + WRONG_RANGE_NEGATIVE_EXCEPTION)
            Validation().validationAmount(LottoPurchaseView.inputLottoPurchase())
        }
        return amount.toInt()
    }

    private fun validationUnit(amount: String): Int {
        try {
            lotto.util.Exception.validateUnitException(amount.toInt())
        } catch (e: IllegalArgumentException) {
            println(EXCEPTION_MESSAGE + WRONG_UNIT_EXCEPTION)
            Validation().validationAmount(LottoPurchaseView.inputLottoPurchase())
        }
        return amount.toInt()
    }

    private fun validationRange(lotto: List<Int>): List<Int> {
        try {
            lotto.forEach { number -> validationRangeException(number) }
        } catch (e: IllegalArgumentException) {
            println(EXCEPTION_MESSAGE + WRONG_RANGE_EXCEPTION)
            Validation().validationLotto(inputWinningNumber().sorted())
        }
        return lotto
    }

    private fun validationDuplication(lotto: List<Int>): List<Int> {
        try {
            lotto.forEach { number -> validationDuplicationException(lotto, number) }
        } catch (e: IllegalArgumentException) {
            println(EXCEPTION_MESSAGE + DUPLICATE_NUMBER_EXCEPTION)
            Validation().validationLotto(inputWinningNumber().sorted())
        }
        return lotto
    }

    fun validationBonusCount(bonus: String): String {
        try {
            validationBonusCountException(bonus)
        } catch (e: IllegalArgumentException) {
            println(EXCEPTION_MESSAGE + WRONG_BONUS_COUNT_EXCEPTION)
            inputBonusNumber()
        }
        return bonus
    }

    fun validationBonusDuplication(bonus: Int, winningNumber: List<Int>): Int {
        try {
            validationBonusDuplicationException(bonus, winningNumber)
        } catch (e: IllegalArgumentException) {
            println(EXCEPTION_MESSAGE + DUPLYCATE_BONUS_EXCEPTION)
            inputBonusNumber()
        }
        return bonus
    }

    fun validationSeparator(number: String): String {
        try {
            validationSeparatorException(number)
        } catch (e: IllegalArgumentException) {
            println(EXCEPTION_MESSAGE + WRONG_SEPARATOR)
            inputWinningNumber()
        }
        return number
    }
}