package lotto

class WinningResult(
    private val lottoTickets: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    private fun calculateStatistics(): Pair<Map<LottoRank, Int>, Int> {
        val statistics = mutableMapOf<LottoRank, Int>()
        var totalPrize = 0
        for (lotto in lottoTickets) {
            val rank = lotto.checkMatch(winningNumbers, bonusNumber)
            if (rank != null) {
                statistics[rank] = statistics.getOrDefault(rank, 0) + 1
                totalPrize += rank.prizeMoney
            }
        }
        return Pair(statistics, totalPrize)
    }

    private fun calculateProfitRate(amount: Int, totalPrize: Int): Double {
        return totalPrize.toDouble() / amount * 100
    }

    fun printResults() {
        val (statistics, totalPrize) = calculateStatistics()
        val profitRate = calculateProfitRate(lottoTickets.size * 1000, totalPrize)
        println("당첨 통계")
        println("---")
        for (rank in LottoRank.entries) {
            val count = statistics[rank] ?: 0
            val prizeMoney = rank.prizeMoney
            val formattedPrizeMoney = String.format("%,d", prizeMoney)
            println("${rank.rankDescription} (${formattedPrizeMoney}원) - ${count}개")
        }

        val formattedProfitRate = String.format("%.1f%%", profitRate)
        println("총 수익률은 $formattedProfitRate 입니다.")
    }
}