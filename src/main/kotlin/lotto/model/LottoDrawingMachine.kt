package lotto.model

import lotto.model.domain.Bonus
import lotto.model.domain.Lotto
import lotto.model.domain.Rank

class LottoDrawingMachine(
    private val lottoTickets: List<Lotto>,
    private val winningNumbers: Lotto,
    private val bonusNumber: Bonus
) {

    fun getRankCounts(): Map<Rank, Int> {
        val resultRank = mutableListOf<Rank>()
        lottoTickets.forEach { lotto -> resultRank.add(findRank(lotto)) }
        return resultRank.groupingBy { rank -> rank }.eachCount()
    }

    private fun findRank(lotto: Lotto): Rank {
        val countOfMatch = lotto.getCountOfMatch(winningNumbers)
        val isBonusMatch = lotto.isContainNumber(bonusNumber.number)
        return Rank.findRank(countOfMatch, isBonusMatch)
    }
}