package lotto.model

import INVALID_BONUS_NUMBER_NUMERIC_MESSAGE

class BonusNumber {
    fun isBonusNumberNumeric(input: String) {
        val numberic = input.toIntOrNull()
        if (numberic == null) {
            throw IllegalArgumentException(INVALID_BONUS_NUMBER_NUMERIC_MESSAGE)
        }
    }
}