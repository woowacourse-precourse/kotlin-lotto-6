package lotto.domain.model

import lotto.util.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.all { it in Constants.LOTTO_START_NUM..Constants.LOTTO_END_NUM }) {
            LOTTO_RANGE_ERROR
        }
        require(numbers.size == Constants.LOTTO_NUM_CNT) {
            LOTTO_CNT_ERROR
        }
        require(numbers.distinct().size == Constants.LOTTO_NUM_CNT) {
            LOTTO_DISTINCT_ERROR
        }
    }

    fun getNumbers() = numbers.toString()

    fun contains(lottoNumber: Int) = numbers.contains(lottoNumber)

    fun hasBonusNumber(winningLotto: WinningLotto) = numbers.contains(winningLotto.bonusNumber)
    fun compareWinningLotto(winningLotto: Lotto): Int {
        return numbers.count { winningLotto.numbers.contains(it) }
    }

    companion object {
        private const val LOTTO_CNT_ERROR = "[ERROR] 로또 숫자의 개수는 ${Constants.LOTTO_NUM_CNT}개여야 합니다."
        private const val LOTTO_DISTINCT_ERROR = "[ERROR] 로또 숫자들 중 중복된 숫자가 있어서는 안됩니다."
        private const val LOTTO_RANGE_ERROR =
            "[ERROR] 로또 숫자는 ${Constants.LOTTO_START_NUM}~${Constants.LOTTO_END_NUM}사이의 숫자여야 합니다."
    }
}
