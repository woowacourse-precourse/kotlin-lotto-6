package lotto.model

import lotto.util.Constants

enum class Rank(val label: String, val count: Int, val money: Int, val countLabel: String) {
    THIRD("3개 일치 (5,000원) - ", 3, 5000, Constants.COUNT),
    FOURTH("4개 일치 (50,000원) - ", 4, 50000, Constants.COUNT),
    FIFTH("5개 일치 (1,500,000원) - ", 5, 1500000, Constants.COUNT),
    FIFTH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 5, 30000000, Constants.COUNT),
    SIXTH("6개 일치 (2,000,000,000원) - ", 6, 2000000000, Constants.COUNT);
}

class Jackpot {
    fun discriminate(answers: List<Int>, bonus: Int, lotto: List<List<Int>>): List<Int> {
        val rank = mutableMapOf<Rank, Int>().apply {
            for (eachRank in Rank.entries) {
                put(eachRank, 0)
            }
        }
        for (eachLotto in lotto) {
            val count = countDiscriminate(answers, eachLotto)
            val bonusCount = bonusDiscriminate(eachLotto, bonus)
            val updatedRank = rankUpdate(count, rank, bonusCount)
            for (eachRank in Rank.entries) {
                rank[eachRank] = updatedRank[eachRank] ?: 0
            }
        }
        return rank.values.toList()
    }

    fun rankUpdate(count: Int, rank: MutableMap<Rank, Int>, bonusCount: Boolean): MutableMap<Rank, Int> {
        val matchingRank = when (count) {
            5 -> if (bonusCount) Rank.FIFTH_WITH_BONUS else Rank.FIFTH
            else -> Rank.entries.find { it.count == count }
        }
        matchingRank?.let { rank[it] = rank.getOrDefault(it, 0) + 1 }
        return rank
    }

    fun countDiscriminate(answers: List<Int>, eachLotto: List<Int>): Int {
        return answers.count { it in eachLotto }
    }

    fun bonusDiscriminate(eachLotto: List<Int>, bonus: Int): Boolean {
        return bonus in eachLotto
    }
}
