package lotto.model

import MATCH_FIVE
import MATCH_FOUR
import MATCH_SIX
import MATCH_THREE

class LottoMatch(lottoTickets: List<LottoTicket>, winningNumber: List<Int>, bonusNumber: Int) {
    val lottoTickets = lottoTickets
    val winningNumber = winningNumber
    val bonusNumber = bonusNumber

    private val lottoResults = mutableMapOf<LottoResult, Int>()

    init {
        for (lottoResult in LottoResult.values()) {
            lottoResults[lottoResult] = 0
        }
    }

    fun countMatch(): List<Int> {
        for (ticket in lottoTickets) {
            countRanks(ticket)
        }
        return lottoResults.values.toList()
    }

    private fun countRanks(ticket: LottoTicket) {
        val hasBonus = ticket.ticket.contains(bonusNumber)
        var matchingNumbers = ticket.ticket.count { it in winningNumber }

        if (hasBonus)
            matchingNumbers++

        val matchingRank = when (matchingNumbers) {
            MATCH_SIX -> if (!hasBonus) LottoResult.FIRST else LottoResult.SECOND
            MATCH_FIVE -> LottoResult.THIRD
            MATCH_FOUR -> LottoResult.FOURTH
            MATCH_THREE -> LottoResult.FIFTH
            else -> null
        }

        matchingRank?.let { lottoResults[it] = lottoResults.getOrDefault(it, 0) + 1 }
    }
}