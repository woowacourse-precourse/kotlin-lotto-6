package lotto.model

import lotto.util.Constant
import lotto.util.Constant.LOTTO_MAX_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_MIN_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_NUMBER_LENGTH_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_SORT_ERROR_MESSAGE
import lotto.util.Exception

class Lotto(private val numbers: List<Int>) {
    init {
        Exception.validateLottoNumber(numbers)
    }

    fun getLottoNumbers() = numbers
}
