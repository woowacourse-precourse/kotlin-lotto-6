package lotto.model

import INVALID_DIVISION_MESSAGE
import INVALID_NUMERIC_MESSAGE
import INVALID_POSITIVE_MESSAGE

class LottoModel {
    fun isPurchaseAmountNumeric(input: String) {
        val numberic = input.toIntOrNull()
        if (numberic == null)
            throw IllegalArgumentException(INVALID_NUMERIC_MESSAGE)
    }

    fun isPurchaseAmountPositive(value: Int) {
        if (value < 0)
            throw IllegalArgumentException(INVALID_POSITIVE_MESSAGE)
    }

    fun isDivisibleBy1000(value: Int) {
        if (value % 1000 != 0)
            throw IllegalArgumentException(INVALID_DIVISION_MESSAGE)
    }
}