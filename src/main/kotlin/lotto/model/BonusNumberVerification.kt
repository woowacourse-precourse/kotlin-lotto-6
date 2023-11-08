package lotto.model

import lotto.config.ExceptionMessage.LOTTO_RANGE_ERROR
import lotto.config.GameConfigValue.MINIMUM_LOTTO_NUMBER
import lotto.config.GameConfigValue.MAXIMUM_LOTTO_NUMBER
import lotto.config.ExceptionMessage.DUPLICATE_VALUES

class BonusNumberVerification(private val bonusNumber: Int, private val lottoNumber: List<Int>) {
    init {
        bonusNumberRangeCheck()
        duplicateNumberCheck()
    }

    private fun bonusNumberRangeCheck() {
        if (bonusNumber !in (MINIMUM_LOTTO_NUMBER)..<MAXIMUM_LOTTO_NUMBER) {
            throw IllegalArgumentException(LOTTO_RANGE_ERROR)
        }
    }

    private fun duplicateNumberCheck() {
        val allNumbers = lottoNumber + bonusNumber
        if (allNumbers.distinct().size != allNumbers.size) {
            throw IllegalArgumentException(DUPLICATE_VALUES)
        }
    }

}