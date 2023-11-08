package lotto.util.validations

import lotto.model.Lotto
import lotto.util.const.ErrorMessage.error_bonus_number
import lotto.util.const.maxLottoWinningNumber
import lotto.util.const.minLottoWinningNumber

object LottoBonusNumbersValidator {
    fun inputNumber(userLottos: Lotto, input: String): Boolean {
        val bonusNumber = input.toIntOrNull()
        if (isUerInputNumberType(bonusNumber) &&
            isUserInputInRange(bonusNumber) &&
            isUerInputDistinct(userLottos, bonusNumber)
        ) return true
        else throw IllegalArgumentException(error_bonus_number)
    }

    private fun isUerInputNumberType(input: Int?): Boolean = input != null
    private fun isUserInputInRange(input: Int?): Boolean =
        input in minLottoWinningNumber..maxLottoWinningNumber

    private fun isUerInputDistinct(userLottos: Lotto, input: Int?): Boolean =
        !userLottos.getNumbers().contains(input)

}