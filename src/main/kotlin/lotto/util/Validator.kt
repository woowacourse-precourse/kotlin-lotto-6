package lotto.util

import lotto.util.GameConstants.LOTTO_PRICE
import lotto.util.GameConstants.LOTTO_SIZE
import lotto.util.GameConstants.MAX_NUMBER
import lotto.util.GameConstants.MIN_NUMBER

object Validator {
    fun validateUnit(input: Int) {
        require(input % LOTTO_PRICE == 0) {
            ErrorMessage.NUMBER_UNIT.getMessage()
        }
    }

    fun validateInteger(input: String) {
        require(input.toIntOrNull() != null) {
            ErrorMessage.NUMBER_INTEGER.getMessage()
        }
    }

    fun validateNatural(input: String) {
        val number = input.toIntOrNull()
        require(number != null && number > 0) {
            ErrorMessage.NUMBER_NATURAL.getMessage()
        }
    }

    fun validateNull(input: String) {
        require(input.trim().isNotEmpty()) {
            ErrorMessage.NUMBER_NULL.getMessage()
        }
    }

    fun validateDuplicate(numbers: List<Int>, input: Int) {
        require(!numbers.contains(input)) {
            ErrorMessage.NUMBER_DUPLICATION.getMessage()
        }
    }

    fun validateLottoRange(input: List<Int>) {
        input.forEach {
            validateRange(it)
        }
    }

    fun validateRange(input: Int) {
        require(input in MIN_NUMBER..MAX_NUMBER) {
            ErrorMessage.NUMBER_RANGE.getMessage()
        }
    }

    fun validateSize(input: List<Int>) {
        require(input.size == LOTTO_SIZE) {
            ErrorMessage.NUMBER_SIZE.getMessage()
        }
    }
}