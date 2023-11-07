package lotto.io.input

import lotto.constants.Exception

class InputValidator {
    fun checkInputDigit(number: String) {
        validateEmpty(number)
        validateNotDigit(number)
        validateIntMax(number)
    }

    fun checkWinningLotto(numbers: String) {
        validateEmpty(numbers)
        validateComma(numbers)
        numbers.split(",").forEach { number ->
            validateNotDigit(number)
            validateIntMax(number)
        }
    }

    private fun validateEmpty(value: String) {
        require(value.isNotEmpty()) { Exception.EMPTY }
    }

    private fun validateNotDigit(value: String) {
        require(value.all { it.isDigit() }) { Exception.DIGIT }
    }

    private fun validateIntMax(value: String) {
        require(value.toIntOrNull() != null) { Exception.INT_MAX }
    }

    private fun validateComma(value: String) {
        require(!(value.startsWith(",") || value.endsWith(",") || value.contains(",,"))) {
            Exception.LOTTO_COMMA
        }
    }
}