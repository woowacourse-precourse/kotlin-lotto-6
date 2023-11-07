package lotto

class WinningResult(
    private val lottoTickets: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    private fun calculateStatistics(): Map<LottoRank, Int> {
        val statistics = mutableMapOf<LottoRank, Int>()
        for (lotto in lottoTickets) {
            val rank = lotto.checkMatch(winningNumbers, bonusNumber)
            if (rank != null) {
                statistics[rank] = statistics.getOrDefault(rank, 0) + 1
            }
        }
        return statistics
    }

    private fun calculateTotalPrize(statistics: Map<LottoRank, Int>): Int {
        return statistics.entries.sumOf { it.key.prizeMoney * it.value }
    }

    private fun calculateProfitRate(amount: Int, totalPrize: Int): Double {
        return totalPrize.toDouble() / amount * 100
    }

    fun printResults() {
        val statistics = calculateStatistics()
        val totalPrize = calculateTotalPrize(statistics)
        val profitRate = calculateProfitRate(lottoTickets.size * 1000, totalPrize)
        for (rank in LottoRank.entries) {
            val count = statistics[rank] ?: 0
            val prizeMoney = rank.prizeMoney
            val formattedPrizeMoney = String.format("%,d", prizeMoney)
            println("${rank.rankDescription} (${formattedPrizeMoney}원) - ${count}개")
        }

        val formattedProfitRate = String.format("%,.1f", profitRate)
        println("총 수익률은 ${formattedProfitRate}%입니다.")
    }
}