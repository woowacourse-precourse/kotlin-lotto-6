package lotto.io.input

import lotto.constants.Exception

class InputValidator {
    fun checkAmount(amount: String) {
        checkEmpty(amount)
        checkNotDigit(amount)
    }

    private fun checkEmpty(value: String) {
        require(value.isNotEmpty()) { Exception.EMPTY }
    }

    private fun checkNotDigit(value: String) {
        require(value.all { it.isDigit() }) { Exception.DIGIT }
    }

    companion object {
        private const val PURCHASE_AMOUNT_UNIT = 1000
    }
}