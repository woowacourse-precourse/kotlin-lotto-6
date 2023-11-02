package lotto.util

import lotto.constant.ErrorMessage

class UserInputValidator {

    fun isNumberFormat(userInput: String) {
        require(userInput.none { char -> !char.isDigit() }) { ErrorMessage.NOT_NUMBER_PURCHASE_AMOUNT.message }
    }

    fun isNumberListFormat(userInput: List<String>) {
        userInput.forEach { require(it.none { char -> !char.isDigit() }) { ErrorMessage.NOT_NUMBER_WINNING_NUMBER.message } }
    }
}