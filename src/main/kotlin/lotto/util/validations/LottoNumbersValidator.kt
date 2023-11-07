package lotto.util.validations

import lotto.util.errorPrefix
import lotto.util.lottoWinningNumberQuantity
import lotto.util.maxLottoWinningNumber
import lotto.util.minLottoWinningNumber

object LottoNumbersValidator {
    fun inputNumbers(input: List<Int?>): Boolean {
        if (isUserInputNumberType(input) &&
            isUserInputInRange(input) &&
            isUerInputRightQuantity(input)
        ) return true
        else throw IllegalArgumentException("$errorPrefix 당첨 번호는 $minLottoWinningNumber~$maxLottoWinningNumber 사이의 중복되지 않는 숫자를 , 로 구분하여 ${lottoWinningNumberQuantity}개를 입력해야 합니다.")
    }

    private fun isUserInputNumberType(input: List<Int?>): Boolean = !input.contains(null)
    private fun isUserInputInRange(input: List<Int?>): Boolean =
        input.filter { it in minLottoWinningNumber..maxLottoWinningNumber }.size == lottoWinningNumberQuantity
    private fun isUerInputRightQuantity(input: List<Int?>): Boolean =
        input.size == lottoWinningNumberQuantity


}