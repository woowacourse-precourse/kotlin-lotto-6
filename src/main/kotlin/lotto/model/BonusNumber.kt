package lotto.model

import INVALID_BONUS_NUMBER_DUPLICATION_MESSAGE
import INVALID_BONUS_NUMBER_NUMERIC_MESSAGE
import INVALID_BONUS_NUMBER_RANGE_MESSAGE
import LOTTO_MAX_NUMBER
import LOTTO_MIN_NUMBER

class BonusNumber {
    fun isBonusNumberNumeric(input: String) {
        val numberic = input.toIntOrNull()
        if (numberic == null) {
            throw IllegalArgumentException(INVALID_BONUS_NUMBER_NUMERIC_MESSAGE)
        }
    }

    fun isBonusNumberRange(input: Int) {
        if (input !in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {
            throw IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE_MESSAGE)
        }
    }

    fun isBonusNumberDuplicate(input: Int, winningNumber: List<Int>) {
        if (winningNumber.contains(input)) {
            throw IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATION_MESSAGE)
        }
    }
}