package lotto.domain

class WinningResult(
    private val lottoTickets: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    fun calculateStatistics(): Map<LottoRank, Int> {
        val statistics = mutableMapOf<LottoRank, Int>()
        for (lotto in lottoTickets) {
            val rank = lotto.checkMatch(winningNumbers, bonusNumber)
            if (rank != null) {
                statistics[rank] = statistics.getOrDefault(rank, 0) + 1
            }
        }
        return statistics
    }

    fun calculateTotalPrize(statistics: Map<LottoRank, Int>): Int {
        return statistics.entries.sumOf { it.key.prizeMoney * it.value }
    }

    fun calculateProfitRate(amount: Int, totalPrize: Int): Double {
        return totalPrize.toDouble() / amount * 100
    }

    fun returnStatisticsResults(): List<Triple<String, String, Int>> {
        val statistics = calculateStatistics()
        return LottoRank.entries.map { rank ->
            val count = statistics[rank] ?: 0
            val prizeMoney = rank.prizeMoney
            val formattedPrizeMoney = String.format("%,d", prizeMoney)
            Triple(rank.rankDescription, formattedPrizeMoney, count)
        }
    }

    fun returnProfitRateResults(statistics: Map<LottoRank, Int>): String {
        val totalPrize = calculateTotalPrize(statistics)
        val profitRate = calculateProfitRate(lottoTickets.size * 1000, totalPrize)

        return String.format("%,.1f", profitRate)
    }
}