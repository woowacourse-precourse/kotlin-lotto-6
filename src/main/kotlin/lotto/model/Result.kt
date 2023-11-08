package lotto.model

import lotto.util.GameConstants.COUNT_FIVE
import lotto.util.GameConstants.COUNT_FOUR
import lotto.util.GameConstants.COUNT_SIX
import lotto.util.GameConstants.COUNT_THREE
import lotto.util.GameConstants.INDEX_1ST
import lotto.util.GameConstants.INDEX_2ND
import lotto.util.GameConstants.INDEX_3RD
import lotto.util.GameConstants.INDEX_4TH
import lotto.util.GameConstants.INDEX_5TH
import lotto.util.GameConstants.NO_RANK

class Result(private val winningNumbers: List<Int>, private val bonus: Int) {
    fun calculateRanking(ticket: List<Int>): Int {
        val matchCount = ticket.intersect(winningNumbers.toSet()).count()
        return when (matchCount) {
            COUNT_THREE -> INDEX_5TH
            COUNT_FOUR -> INDEX_4TH
            COUNT_FIVE -> countBonus(ticket)
            COUNT_SIX -> INDEX_1ST
            else -> NO_RANK
        }
    }

    private fun countBonus(ticket: List<Int>): Int {
        return when (ticket.contains(bonus)) {
            true -> INDEX_2ND
            false -> INDEX_3RD
        }
    }
}