package lotto.domain.service

import lotto.Lotto

class LottoCalculator(private val winningNumbers: List<Int>, private val bonusNumber: Int) {

    fun checkWinningRank(lotto: Lotto): Int {
        return when (getWinningCount(lotto)) {
            3 -> 5
            4 -> 4
            5 -> {
                if (hasBonusNumber(lotto)) 2
                else 3
            }

            6 -> 1
            else -> 6
        }
    }

    private fun getWinningCount(lotto: Lotto) =
        winningNumbers.count { winningNumber -> lotto.getNumbers().contains(winningNumber) }

    private fun hasBonusNumber(lotto: Lotto) = lotto.getNumbers().contains(bonusNumber)

}