package lotto.util

import lotto.constants.Error
import lotto.constants.LottoConstants

object LottoValidatorUtil {

    fun checkWinningNumberSize(numbers: List<Int>) {
        when {
            numbers.size != LottoConstants.LOTTO_SIZE -> throw IllegalArgumentException(Error.EXCEPTION_MESSAGE_WINNING_NUMBER_SIZE_INVALID)
            numbers.toSet().size != LottoConstants.LOTTO_SIZE -> throw IllegalArgumentException(Error.EXCEPTION_MESSAGE_WINNING_NUMBER_DUPLICATED_NUMBER_EXIST)
        }
    }

    fun checkNumberInRange(number: Int) {
        if (number !in LottoConstants.LOTTO_RANGE) {
            throw IllegalArgumentException(Error.EXCEPTION_MESSAGE_NOT_IN_RANGE)
        }
    }
}