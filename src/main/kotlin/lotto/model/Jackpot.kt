package lotto.model

enum class Rank(val label: String, val count: Int, val countLabel: String, val bonus: Boolean) {
    THIRD(Constants.THREE_SAME, 3, Constants.COUNT, false),
    FOURTH(Constants.FOUR_SAME, 4, Constants.COUNT, false),
    FIFTH(Constants.FIVE_SAME, 5, Constants.COUNT, false),
    FIFTH_WITH_BONUS(Constants.FIVE_WITH_BONUS_SAME, 5, Constants.COUNT, true),
    SIXTH(Constants.SIX_SAME, 6, Constants.COUNT, false);
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
        val matchingRank = Rank.values().find { it.count == count && it.bonus == bonusCount }
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
