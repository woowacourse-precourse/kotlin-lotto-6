package lotto.domain

class LottoResult(private val lottos: Lottos, private val winningLotto: WinningLotto) {
    private val results = mutableMapOf<Rank, Int>()

    init {
        initResults()
        updateResults()
    }

    private fun initResults() {
        for (rank in Rank.entries) {
            results[rank] = 0
        }
    }

    private fun updateResults() {
        for (lotto in lottos.getLottos()) {
            val count = lottos.getMatchingCount(lotto, winningLotto)
            val isBonus = lottos.isBonusMatch(lotto, winningLotto)
            val rank = Rank.checkRank(count, isBonus)
            addCount(rank)
        }
    }

    private fun addCount(rank: Rank) {
        results.replace(rank, results.getValue(rank) + 1)
    }

    fun getRateOfReturn(): Double {
        return (calculateTotalPrize().toDouble() / lottos.getPrice()) * 100
    }

    private fun calculateTotalPrize(): Int {
        var totalPrize = 0
        for (rank in Rank.entries) {
            totalPrize += results[rank]!! * rank.getPrize(rank)
        }
        return totalPrize
    }

    override fun toString(): String {
        return buildString {
            for (rank in Rank.entries.filterNot { rank -> rank == Rank.NONE }) {
                append(rank.getMessage(results[rank]))
            }
        }
    }
}

