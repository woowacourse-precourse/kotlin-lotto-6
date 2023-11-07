package lotto.utils

import constants.ExceptionMessages
import lotto.constants.Constants

object InputViewValidation {

    fun validateUserAmount(userInput: String) {
        try {
            val amount = userInput.toInt()

            if (amount <= 0) throw IllegalArgumentException(ExceptionMessages.EXCEPTION_PURCHASE_NO_MORE_THAN_ZERO)
            if (amount % Constants.LOTTO_PRICE != 0) throw IllegalArgumentException(ExceptionMessages.EXCEPTION_PURCHASE_DIVISION)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessages.EXCEPTION_PURCHASE_STRING)
        }
    }

    fun getValidatedNumbersList(winningNumbers: List<String>): List<Int> = try {
        val winningNumbersList = winningNumbers.map {
            it.toInt()
        }
        validateWinningNumbersList(winningNumbersList)

        winningNumbersList
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ExceptionMessages.EXCEPTION_WINNING_NUMBERS_TYPE)
    }

    fun validateWinningNumbersList(winningNumbers: List<Int>) {
        if (winningNumbers.size != Constants.LOTTO_SIZE) throw IllegalArgumentException(ExceptionMessages.EXCEPTION_WINNING_NUMBERS_SIZE)
        if (winningNumbers.size != winningNumbers.distinct().count()) {
            throw IllegalArgumentException(ExceptionMessages.EXCEPTION_WINNING_NUMBERS_DUPLICATED)
        }
        winningNumbers.onEach {
            if (it !in Constants.MIN_NUM..Constants.MAX_NUM) throw IllegalArgumentException(ExceptionMessages.EXCEPTION_WINNING_NUMBERS_RANGE)
        }
    }

    fun getValidatedBonusNumber(bonus: String, winningNumbers: List<Int>): Int = try {
        val bonusNum = bonus.toInt()
        if (bonusNum !in Constants.MIN_NUM..Constants.MAX_NUM) throw IllegalArgumentException(ExceptionMessages.EXCEPTION_BONUS_NUMBER_RANGE)
        if (bonusNum in winningNumbers) throw IllegalArgumentException(ExceptionMessages.EXCEPTION_BONUS_NUMBER_DUPLICATED)

        bonusNum
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ExceptionMessages.EXCEPTION_BONUS_NUMBER_TYPE)
    }
}