package lotto.util

import lotto.constant.ErrorMessage

class UserInputValidator {


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
        userInput.forEach { require(it.none { char -> !char.isDigit() }) }
    }

    companion object {
        private const val MIN_PURCHASE_AMOUNT = 1000
        private const val PURCHASE_AMOUNT_CHANGES = 0
    }
}