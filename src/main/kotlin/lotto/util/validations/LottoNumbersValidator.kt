package lotto.util.validations

import lotto.util.const.ErrorMessage.error_lotto_numbers
import lotto.util.const.lottoWinningNumberQuantity
import lotto.util.const.maxLottoWinningNumber
import lotto.util.const.minLottoWinningNumber

object LottoNumbersValidator {
    fun inputNumbers(input: List<Int?>): Boolean {
        if (isUserInputNumberType(input) &&
            isUserInputInRange(input) &&
            isUerInputRightQuantity(input)
        ) return true
        else throw IllegalArgumentException(error_lotto_numbers)
    }

    private fun isUserInputNumberType(input: List<Int?>): Boolean = !input.contains(null)
    private fun isUserInputInRange(input: List<Int?>): Boolean =
        input.filter { it in minLottoWinningNumber..maxLottoWinningNumber }.size == lottoWinningNumberQuantity
    private fun isUerInputRightQuantity(input: List<Int?>): Boolean =
        input.size == lottoWinningNumberQuantity


}