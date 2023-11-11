package lotto.domain

class LottoResult {
    private val results = mutableMapOf<Rank, Int>()

    init {
        for (rank in Rank.entries) {
            results[rank] = 0
        }
    }

    fun getRankCount(rank: Rank): Int = results[rank]!!

    fun updateCount(rank: Rank) {
        results.replace(rank, results.getValue(rank) + 1)
    }

    override fun toString(): String {
        return buildString {
            for (rank in Rank.entries.filterNot { rank ->
                rank == Rank.NONE
            }) {
                append(rank.getMessage(results[rank]!!))
            }
        }
    }
}