package lotto.model

import lotto.config.ExceptionMessage.LOTTO_RANGE_ERROR
import lotto.config.GameConfigValue.MINIMUM_LOTTO_NUMBER
import lotto.config.GameConfigValue.MAXIMUM_LOTTO_NUMBER
import lotto.config.ExceptionMessage.LOTTO_DEFAULT_DIGIT_ERROR
import lotto.config.GameConfigValue.LOTTO_DEFAULT_DIGIT
import lotto.config.ExceptionMessage.DUPLICATE_VALUES

class Lotto(private val numbers: List<Int>) {
    init {
        checkLottoNumberSize()
        lottoNumberRangeCheck()
        duplicateNumberCheck()
    }
    private fun checkLottoNumberSize() {
        if (numbers.size != LOTTO_DEFAULT_DIGIT){
            throw IllegalArgumentException(LOTTO_DEFAULT_DIGIT_ERROR)
        }
    }
    private fun lottoNumberRangeCheck() {
        numbers.forEach {
            if (it !in (MINIMUM_LOTTO_NUMBER)..MAXIMUM_LOTTO_NUMBER){
                throw IllegalArgumentException(LOTTO_RANGE_ERROR)
            }
        }
    }
    private fun duplicateNumberCheck() {
        if (numbers.distinct().size != numbers.size){
            throw IllegalArgumentException(DUPLICATE_VALUES)
        }
    }
}


