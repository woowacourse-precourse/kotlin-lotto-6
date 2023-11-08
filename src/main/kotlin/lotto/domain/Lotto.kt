package lotto.domain

import lotto.util.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.CNT_LOTTO_NUMBER)
        require(numbers.toSet().size == Constants.CNT_LOTTO_NUMBER)
        require(numbers.all { it in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER })
    }

    fun checkMatch(winningNumbers: List<Int>, bonusNumber: Int): LottoRank? {
        val matchingNumbers = numbers.intersect(winningNumbers.toSet())
        return when (matchingNumbers.size) {
            6 -> LottoRank.FIRST
            5 -> if (numbers.contains(bonusNumber)) LottoRank.SECOND else LottoRank.THIRD
            4 -> LottoRank.FOURTH
            3 -> LottoRank.FIFTH
            else -> null
        }

    }

    fun returnLottoNumbers(): List<Int> = numbers

}
