package lotto.domain

import lotto.exception.LottoNumberException

data class LottoNumber(private val value: Int) {
    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }

    init {
        require(value in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
            LottoNumberException.OUT_RANGE.getLottoNumberRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}