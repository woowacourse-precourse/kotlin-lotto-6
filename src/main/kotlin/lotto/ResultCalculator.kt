package lotto

class ResultCalculator {
    fun calculateResults(tickets: List<Lotto>, winningTicket: Lotto, bonusNumber: Int): LottoResult {
        val statistic = calculateStatistics(tickets, winningTicket, bonusNumber)
        val totalPrize = calculateTotalPrize(statistic)
        return LottoResult(statistic, totalPrize)
    }

    private fun calculateStatistics(tickets: List<Lotto>, winningTicket: Lotto, bonusNumber: Int): Map<Rank, Int> {
        val rankCount = tickets.mapNotNull { ticket ->
            tryToFindRank(ticket, winningTicket, bonusNumber)
        }.groupingBy { it }.eachCount()

        return Rank.values().associateWith { rank -> rankCount.getOrDefault(rank, 0) }
    }

    private fun tryToFindRank(ticket: Lotto, winningTicket: Lotto, bonusNumber: Int): Rank? =
        runCatching {
            val matchCount = ticket.match(winningTicket)
            val matchBonus = ticket.matchBonus(bonusNumber)
            Rank.findRank(matchCount, matchBonus)
        }.getOrNull()

    private fun calculateTotalPrize(statistic: Map<Rank, Int>): Double =
        statistic.entries.sumOf { calculatePrizeForRank(it.key, it.value) }

    private fun calculatePrizeForRank(rank: Rank, ticketCount: Int): Double =
        (rank.prize * ticketCount).toDouble()
}
