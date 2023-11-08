package lotto.domain.validator

import lotto.domain.Lotto.Companion.LOTTO_MAX_VALUE
import lotto.domain.Lotto.Companion.LOTTO_MIN_VALUE

object InputValidator {
    fun validateInputIsInt(input: String, message: String) = requireNotNull(input.toIntOrNull()) {
        "[ERROR] $message"
    }

    fun validateInputIsNotZero(input: String, message: String) = require(input.toInt() != 0) {
        "[ERROR] $message"
    }

    fun validateIntListHasUniqueElements(numbers: List<Int>, message: String) =
        require(numbers.size == numbers.toSet().size) {
            "[ERROR] $message"
        }

    fun validateStringListHasUniqueElements(numbers: List<String>, message: String) =
        require(numbers.size == numbers.toSet().size) {
            "[ERROR] $message"
        }

    fun validateNumberInRange(number: Int, message: String) =
        require(number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE) {
            "[ERROR] $message"
        }

    fun validateNumbersInRange(numbers: List<Int>, message: String) =
        numbers.map { number ->
            require(number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE) {
                "[ERROR] $message"
            }
        }

    fun validateInputsInRange(numbers: List<String>, message: String) =
        numbers.map {
            val number = it.toInt()

            require(number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE) {
                "[ERROR] $message"
            }
        }
}