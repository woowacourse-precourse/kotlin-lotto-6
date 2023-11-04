package lotto.model


import lotto.config.ExceptionMessage.LOTTO_RANGE_ERROR
import lotto.config.GameConfigValue.MINIMUM_LOTTO_NUMBER
import lotto.config.GameConfigValue.MAXIMUM_LOTTO_NUMBER
import lotto.config.ExceptionMessage.LOTTO_DEFAULT_DIGIT_ERROR
import lotto.config.GameConfigValue.LOTTO_DEFAULT_DIGIT

class LottoNumberVerification {
    fun userLottoNumberCheck(lottoNumber: List<String>):List<String>{
        checkLottoNumberSize(lottoNumber)
        lottoNumberRangeCheck(lottoNumber)

        return lottoNumber
    }

    private fun checkLottoNumberSize(lottoNumber: List<String>) {
        if (lottoNumber.size != LOTTO_DEFAULT_DIGIT) {
            throw IllegalArgumentException(LOTTO_DEFAULT_DIGIT_ERROR)
        }
    }

    private fun lottoNumberRangeCheck(lottoNumber: List<String>) {
        lottoNumber.forEach {
            if (it.toInt() !in (MINIMUM_LOTTO_NUMBER)..<MAXIMUM_LOTTO_NUMBER) {
                throw IllegalArgumentException(LOTTO_RANGE_ERROR)
            }
        }
    }
}