package lotto.model

import INVALID_WINNING_NUMBER_DUPLICATION_MESSAGE
import INVALID_WINNING_NUMBER_NUMERIC_MESSAGE
import INVALID_WINNING_NUMBER_RANGE_MESSAGE
import INVALID_WINNING_NUMBER_SIZE_MESSAGE
import LOTTO_MAX_NUMBER
import LOTTO_MIN_NUMBER
import LOTTO_SIZE

class WinningNumber {

    fun isWinningNumberSize(input: List<String>) {
        if (input.size != LOTTO_SIZE) {
            throw IllegalArgumentException(INVALID_WINNING_NUMBER_SIZE_MESSAGE)
        }
    }

    fun isWinningNumberNumeric(input: List<String>) {
        for (number in input) {
            if (number.toIntOrNull() == null) {
                throw IllegalArgumentException(INVALID_WINNING_NUMBER_NUMERIC_MESSAGE)
            }
        }
    }

    fun isWinningNumberRange(input: List<Int>) {
        for (number in input) {
            if (number !in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {
                throw IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE_MESSAGE)
            }
        }
    }

    fun isWinningNumberDuplicate(input: List<Int>) {
        if (input.size != input.distinct().size) {
            throw IllegalArgumentException(INVALID_WINNING_NUMBER_DUPLICATION_MESSAGE)
        }
    }
}