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

}