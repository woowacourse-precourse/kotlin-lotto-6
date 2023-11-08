package lotto.model

import INVALID_DIVISION_MESSAGE
import INVALID_NUMERIC_MESSAGE
import INVALID_POSITIVE_MESSAGE
import ZERO

class LottoMoney {
    fun isMoneyToBuyNumeric(input: String) {
        val numberic = input.toIntOrNull()
        if (numberic == null)
            throw IllegalArgumentException(INVALID_NUMERIC_MESSAGE)
    }

    fun isMoneyToBuyPositive(value: Int) {
        if (value <= ZERO)
            throw IllegalArgumentException(INVALID_POSITIVE_MESSAGE)
    }

    fun isMoneyToBuyDivisibleBy1000(value: Int) {
        if (value % 1000 != ZERO)
            throw IllegalArgumentException(INVALID_DIVISION_MESSAGE)
    }
}