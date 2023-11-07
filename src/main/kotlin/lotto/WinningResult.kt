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

    fun printResults() {
        val statistics = calculateStatistics()
        println("당첨 통계")
        println("---")
        for (rank in LottoRank.entries) {
            val count = statistics[rank] ?: 0
            val prizeMoney = rank.prizeMoney
            val formattedPrizeMoney = String.format("%,d", prizeMoney)
            println("${rank.rankDescription} (${formattedPrizeMoney}원) - ${count}개")
        }
    }
}