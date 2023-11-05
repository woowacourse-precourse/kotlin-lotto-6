package lotto.domain.model

import lotto.util.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            LOTTO_CNT_ERROR
        }
        require(numbers.distinct().size == Constants.LOTTO_NUM_CNT) {
            LOTTO_DISTINCT_ERROR
        }
    }

    fun getNumbers() = numbers.toString()

    companion object {
        private const val LOTTO_CNT_ERROR = "[ERROR] 로또 숫자의 개수는 ${Constants.LOTTO_NUM_CNT}개여야 합니다."
        private const val LOTTO_DISTINCT_ERROR = "[ERROR] 로또 숫자들 중 중복된 숫자가 있어서는 안됩니다."
    }
}
