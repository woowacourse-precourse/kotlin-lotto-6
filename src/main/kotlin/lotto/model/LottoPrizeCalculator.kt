package lotto.model

import lotto.model.seller.Ticket

class LottoPrizeCalculator(private val winningNumbers: Lotto, private val bonus: Bonus) {

    fun issueLottoResultReceipt(ticket: Ticket): PrizeReceipt {
        return convertToPrizeReceipt(ticket)
    }

    private fun convertToPrizeReceipt(ticket: Ticket): PrizeReceipt {
        val countByRank = mutableMapOf<Rank, Int>()
        ticket.read { lotto ->
            val matchingCount = lotto.getMatchCount(winningNumbers)
            val isMatchedBonus = lotto.isMatchedBonus(bonus.number)
            val rank = Rank.of(matchingCount, isMatchedBonus)
            if (rank != null) countByRank[rank] = countByRank.getOrDefault(rank, INITIAL_COUNT) + 1
        }
        return PrizeReceipt(ticket.cost, countByRank)
    }

    companion object {
        private const val INITIAL_COUNT = 0
    }
}