package lotto.domain.service

import lotto.Lotto
import lotto.domain.enum.winning.RankCount
import lotto.domain.model.Winning

class LottoCalculator(private val winning:Winning) {

    fun checkWinningRank(lotto: Lotto): Int {
        return when (getWinningCount(lotto)) {
            RankCount.FIFTH.count -> RankCount.FIFTH.rank
            RankCount.FOURTH.count -> RankCount.FOURTH.rank
            RankCount.SECOND.count -> {
                if (hasBonusNumber(lotto)) RankCount.SECOND.rank
                else RankCount.THIRD.rank
            }

            RankCount.FIRST.count -> RankCount.FIRST.rank
            else -> RankCount.NOT.rank
        }
    }

    private fun getWinningCount(lotto: Lotto) =
        winning.numbers.count { winningNumber -> lotto.getNumbers().contains(winningNumber) }

    private fun hasBonusNumber(lotto: Lotto) = lotto.getNumbers().contains(winning.bonusNumber)

}