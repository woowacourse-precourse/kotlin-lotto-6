package lotto

import lotto.io.UserInterface

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.distinct().size)
    }

    fun showNumbers() {
        val ui = UserInterface()
        ui.printLotto(numbers)
    }

    fun compareToWinningLotto(winningLotto: Lotto, bonusNumber: Int): LottoRank {

        val matchedCount = getMatchedCount(winningLotto, bonusNumber)
        if (matchedCount == 5) {
            return getThisRank(matchedCount, bonusNumber)
        }
        return getThisRank(matchedCount)
    }

    private fun getMatchedCount(winningLotto: Lotto, bonusNumber: Int): Int {
        var matchedCount = 0
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


}
