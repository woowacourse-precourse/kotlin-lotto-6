package lotto.domain

class Result {
    private val result = mutableMapOf<Rank, Int>()

    init {
        for (rank in Rank.entries) {
            result[rank] = 0
        }
    }

    fun put(rank: Rank) {
        result.replace(rank, result.getValue(rank) + 1)
    }

    fun getTotalReward(): Int {
        var totalReward = 0
        for (rank in Rank.entries) {
            totalReward += result[rank]!! * rank.getReward(rank)
        }
        return totalReward
    }

    override fun toString(): String {
        return buildString {
            for (rank in Rank.entries.filterNot { it == Rank.NONE }) {
                append(rank.getMessage(result[rank]))
            }
        }
    }
}

