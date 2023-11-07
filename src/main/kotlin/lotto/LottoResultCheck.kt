package lotto


fun rewardRateCalculate(reward: Long, price: Int): Double {
    return reward.toDouble() * 100 / price.toDouble()
}

fun calculateTotalReward(rankCounts: Map<LottoRank, Int>): Long {
    var reward: Long = 0
    rankCounts.forEach {
        val (rank, count) = it
        reward += rank.prize * count
    }
    return reward
}

fun calculateRankCount(lottoTickets: List<Lotto>, winningNumber: Pair<List<Int>, Int>): Map<LottoRank, Int> {
    val rankCounts: MutableMap<LottoRank, Int> = mutableMapOf<LottoRank, Int>().withDefault { 0 }
    lottoTickets.forEach {
        val rank = gameRank(it, winningNumber)
        rankCounts[rank] = rankCounts.getValue(rank) + 1
    }
    return rankCounts
}
