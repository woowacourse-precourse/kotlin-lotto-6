package lotto

import lotto.LottoData.stats

object LottoCalculating {

    fun calculateStats(purchasedTickets: List<List<Int>>, winningNumbers: List<Int>, bonusNumber: Int) {

        purchasedTickets.forEach { ticket ->
            val matchCount = ticket.intersect(winningNumbers).size

            when (matchCount) {
                3 -> increaseStat(MatchType.THREE_MATCH)
                4 -> increaseStat(MatchType.FOUR_MATCH)
                5 -> if (ticket.contains(bonusNumber)) increaseStat(MatchType.FIVE_MATCH_WITH_BONUS)
                else increaseStat(MatchType.FIVE_MATCH)
                6 -> increaseStat(MatchType.SIX_MATCH)
            }
        }
    }


    fun calculateEarnings(): Double {

        val totalEarnings = stats.map { it.key.prize * it.value }.sum()
        val totalInvestment = LottoData.purchaseNum * 1000
        return (totalEarnings.toDouble() / totalInvestment * 100).roundTo2DecimalPlaces()

    }

    private fun increaseStat(matchType: MatchType) {
        stats[matchType] = stats.getValue(matchType) + 1
    }


    private fun Double.roundTo2DecimalPlaces() = "%,.2f".format(this).toDouble()


}