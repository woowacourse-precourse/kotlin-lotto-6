package lotto.util

import lotto.constant.ErrorMessage
import java.util.regex.Pattern

class UserInputValidator {

    fun isBlankInput(userInput: String) {
        require(userInput.isNotEmpty()) { ErrorMessage.NOT_BLANK_INPUT.message }
    }

    fun isPurchaseAmountFormat(userInput: String) {
        require(userInput.none { char -> !char.isDigit() }) { ErrorMessage.NOT_NUMBER_PURCHASE_AMOUNT.message }
        val purchaseAmount = userInput.toInt()
        require(
            purchaseAmount >= MIN_PURCHASE_AMOUNT && purchaseAmount % MIN_PURCHASE_AMOUNT == PURCHASE_AMOUNT_CHANGES
        ) { ErrorMessage.NOT_PURCHASE_AMOUNT_FORMAT.message }
    }


    fun isBonusNumberFormat(userInput: String) {
        require(userInput.none { char -> !char.isDigit() }) { ErrorMessage.NOT_BONUS_NUMBER_FORMAT.message }
    }

    fun isNumberListFormat(userInput: List<String>) {
        userInput.forEach { require(it.none { char -> !char.isDigit() }) { ErrorMessage.NOT_NUMBER_WINNING_NUMBER.message } }
    }

    fun isRightWinningNumberFormat(userInput: String) {
        require(NUMBER_PATTERN.matcher(userInput).matches()) { ErrorMessage.NOT_WINNING_NUMBER_PATTERN.message }
    }

    companion object {
        private const val MIN_PURCHASE_AMOUNT = 1000
        private const val PURCHASE_AMOUNT_CHANGES = 0
        private val NUMBER_PATTERN = Pattern.compile("^([0-9]+(,[0-9]+)+)\$")
    }
}