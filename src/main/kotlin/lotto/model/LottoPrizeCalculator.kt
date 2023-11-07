package lotto.model

import lotto.model.seller.Ticket

class LottoPrizeCalculator(private val winningNumbers: Lotto, private val bonus: Ball) {

    fun issueLottoResultReceipt(ticket: Ticket): PrizeReceipt {
        val prizeReceipt = PrizeReceipt(ticket.cost)
        ticket.read { lotto ->
            val matchingCount = lotto.getMatchCount(winningNumbers)
            val isMatchedBonus = lotto.isMatchedBonus(bonus)
            val rank = Rank.of(matchingCount, isMatchedBonus)
            if (rank != null) prizeReceipt.recordRank(rank)
        }
        return prizeReceipt
    }
}