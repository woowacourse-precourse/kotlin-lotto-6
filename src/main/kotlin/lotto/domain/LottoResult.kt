package lotto.domain

class LottoResult {
    private val results = mutableMapOf<Rank, Int>()

    init {
        for (rank in Rank.entries) {
            results[rank] = 0
        }
    }

    fun addCount(rank: Rank) {
        results.replace(rank, results.getValue(rank) + 1)
    }

    fun getRateOfReturn(inputMoney: Int): Double {
        return (calculateTotalPrize().toDouble() / inputMoney) * 100
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

