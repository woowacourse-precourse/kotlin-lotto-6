package lotto.model

import INVALID_WINNING_NUMBER_NUMERIC_MESSAGE

class WinningNumber {
    fun isWinningNumberNumeric(input: List<String>) {
        for (number in input) {
            if (number.toIntOrNull() == null)
                throw IllegalArgumentException(INVALID_WINNING_NUMBER_NUMERIC_MESSAGE)
        }
    }
}