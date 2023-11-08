package lotto.model

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
        when (count) {
            3 -> rank[Rank.THIRD] = rank.getOrDefault(Rank.THIRD, 0) + 1
            4 -> rank[Rank.FOURTH] = rank.getOrDefault(Rank.FOURTH, 0) + 1
            5 -> {
                if (bonusCount) {
                    rank[Rank.FIFTH_WITH_BONUS] = rank.getOrDefault(Rank.FIFTH_WITH_BONUS, 0) + 1
                } else {
                    rank[Rank.FIFTH] = rank.getOrDefault(Rank.FIFTH, 0) + 1
                }
            }

            6 -> rank[Rank.SIXTH] = rank.getOrDefault(Rank.SIXTH, 0) + 1
        }
        return rank
    }

    fun countDiscriminate(answers: List<Int>, eachLotto: List<Int>): Int {
        return answers.count { it in eachLotto }
    }

    fun bonusDiscriminate(eachLotto: List<Int>, bonus: Int): Boolean {
        return bonus in eachLotto
    }
}
