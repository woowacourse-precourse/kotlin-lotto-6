package lotto.io.input

import lotto.constants.Exception

class InputValidator {
    fun checkAmount(amount: String) {
        checkEmpty(amount)
        checkNotDigit(amount)
    }

    fun checkWinningLotto(numbers: String) {
        checkEmpty(numbers)
        checkComma(numbers)
        numbers.split(",").forEach { number -> checkNotDigit(number) }
    }

    private fun checkEmpty(value: String) {
        require(value.isNotEmpty()) { Exception.EMPTY }
    }

    private fun checkNotDigit(value: String) {
        require(value.all { it.isDigit() }) { Exception.DIGIT }
    }

    private fun checkComma(value: String) {
        require(!(value.startsWith(",") || value.endsWith(",") || value.contains(",,"))) {
            Exception.COMMA
        }
    }

    companion object {
        private const val PURCHASE_AMOUNT_UNIT = 1000
    }
}