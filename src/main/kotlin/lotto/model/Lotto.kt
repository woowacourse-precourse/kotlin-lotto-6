package lotto.model

import lotto.constants.LottoConstants
import lotto.constants.LottoConstants.LOTTO_SIZE
import lotto.message.Exception

class Lotto(private val numbers: List<Int>) {
    init {
        checkLottoNumbers(numbers)
    }

    private fun checkLottoNumbers(lottoNumber: List<Int>): List<Int> {
        require(lottoNumber.isNotEmpty()) { Exception.INPUT_IS_BLANK }
        require(lottoNumber.size == LOTTO_SIZE) { Exception.INVALID_COUNT }
        require(lottoNumber.toSet().size == LOTTO_SIZE) { Exception.DUPLICATED_NUMBER }
        require(lottoNumber.all { it in LottoConstants.MIN_LOTTO_NUMBER..LottoConstants.MAX_LOTTO_NUMBER }) { Exception.INVALID_RANGE_NUMBER }

        return lottoNumber
    }

    fun getNumber(): List<Int> {
        return numbers
    }
}
