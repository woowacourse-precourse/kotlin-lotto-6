package lotto.model

import lotto.Constants.Companion.ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE
import lotto.Constants.Companion.ERROR_INVALID_NUMBER_COUNT_MESSAGE
import lotto.Constants.Companion.ERROR_INVALID_WINNING_NUMBER_NEGATIVE_MESSAGE
import lotto.Constants.Companion.ERROR_OUT_OF_RANGE_NUMBER_MESSAGE
import lotto.Constants.Companion.MAX_LOTTO_NUMBER
import lotto.Constants.Companion.MIN_LOTTO_NUMBER

class Lotto(private var numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ERROR_INVALID_NUMBER_COUNT_MESSAGE }
        require(numbers.distinct().size == 6) { ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { ERROR_OUT_OF_RANGE_NUMBER_MESSAGE }
        require(numbers.any { it > 0 }) { ERROR_INVALID_WINNING_NUMBER_NEGATIVE_MESSAGE }
    }

    val getNumber: List<Int>
        get() = numbers


}