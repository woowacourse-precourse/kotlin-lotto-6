package lotto.util

import lotto.presentation.LottoPurchaseView.inputLottoPurchase

object Exception {
    fun validateTypeException(amount: String) {
        requireNotNull(amount.toIntOrNull()) { EXCEPTION_MESSAGE + WRONG_NUMBER_EXCEPTION }
    }

    fun validateNegativeException(amount: Int) {
        require(amount >= 0) { EXCEPTION_MESSAGE + WRONG_RANGE_NEGATIVE_EXCEPTION }
    }

    fun validateUnitException(amount: Int) {
        require(amount % LOTTO_PRICE_STANDARD == 0 && amount > 0) { EXCEPTION_MESSAGE + WRONG_UNIT_EXCEPTION }
    }
}