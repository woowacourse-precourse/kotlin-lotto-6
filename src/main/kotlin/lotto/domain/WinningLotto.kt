package lotto.domain

import lotto.Lotto

class WinningLotto(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    val results = mutableMapOf<Rank, Int>(
        Rank.FIFTH to 0,
        Rank.FOURTH to 0,
        Rank.THIRD to 0,
        Rank.SECOND to 0,
        Rank.FIRST to 0,
    )

    private var profit = 0L

    fun checkLottoTicketResult(lottoTickets: List<Lotto>) {
        lottoTickets.forEach {
            val matchedNumbersCount = it.getNumbers().intersect(winningNumbers.toSet()).size
            val isBonusMatched = matchedNumbersCount == 5 && it.getNumbers().contains(bonusNumber)

            val lottoRank = Rank.fromMatchedNumbers(matchedNumbersCount, isBonusMatched)
            if (lottoRank != Rank.NONE) results[lottoRank] = results.getOrDefault(lottoRank, 0) + 1
        }
    }

    fun calculateProfitRate(lottoTicketsCount: Int): Float {
        calculateProfit()
        val moneySpent = lottoTicketsCount * Lotto.LOTTO_PRICE_PER_GAME
        return (profit * 100f) / moneySpent
    }

    private fun calculateProfit() {
        results.forEach { (rank, count) ->
            profit += rank.prize * count
        }
    }
}