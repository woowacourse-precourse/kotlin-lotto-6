package lotto.util.validations

import lotto.model.Lotto
import lotto.util.errorPrefix
import lotto.util.maxLottoWinningNumber
import lotto.util.minLottoWinningNumber

object LottoBonusNumbersValidator {
    fun inputNumber(userLottos: Lotto, input: String): Boolean {
        val bonusNumber = input.toIntOrNull()
        if (isUerInputNumberType(bonusNumber) &&
            isUserInputInRange(bonusNumber) &&
            isUerInputDistinct(userLottos, bonusNumber)
        ) return true
        else throw IllegalArgumentException("$errorPrefix 보너스 번호는 $minLottoWinningNumber~$maxLottoWinningNumber 사이의 숫자 중 당첨 번호와 중복 되지 않는 수 하나를 입력해야 합니다.")
    }

    private fun isUerInputNumberType(input: Int?): Boolean = input != null
    private fun isUserInputInRange(input: Int?): Boolean =
        input in minLottoWinningNumber..maxLottoWinningNumber

    private fun isUerInputDistinct(userLottos: Lotto, input: Int?): Boolean =
        !userLottos.getNumbers().contains(input)

}