package lotto.model

import lotto.util.Const

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.distinct().size)
    }

    fun compareToWinningLotto(winningLotto: Lotto, bonusNumber: Int): LottoRank {
        val matchedCount = getMatchedCount(winningLotto)

        if (matchedCount == Const.CAN_BE_SECOND_NUMBER) {
            return getThisRank(matchedCount, bonusNumber)
        }
        return getThisRank(matchedCount)
    }

    private fun getMatchedCount(winningLotto: Lotto): Int {
        var matchedCount = Const.ZERO

        for (number in numbers) {
            if (winningLotto.numbers.contains(number)) {
                matchedCount++
            }
        }
        return matchedCount
    }

    private fun getThisRank(matchedCount: Int): LottoRank {
        for (rank in LottoRank.values()) {
            if (rank.matchedCount == matchedCount) {
                return rank
            }
        }
        return LottoRank.NOTHING
    }

    private fun getThisRank(matchedCount: Int, bonusNumber: Int): LottoRank {
        if (numbers.contains(bonusNumber)) {
            return LottoRank.SECOND
        }
        return LottoRank.THIRD
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }
}
