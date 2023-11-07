package lotto

class LottoWinResult {

    private val ranks = mutableListOf(0, 0, 0, 0, 0, 0)

    fun getRanks(): List<Int> = ranks.toList()

    fun calculateRank(ball: Int, bonus: Boolean) {
        when (ball) {
            6 -> ranks[Rank.ALL_MATCH.grade] += 1
            5 -> ranks[calculateRankWithBonus(bonus)] += 1
            4 -> ranks[Rank.FOUR_MATCH.grade] += 1
            3 -> ranks[Rank.FOUR_MATCH.grade] += 1
            else -> ranks[Rank.NOT_MATCH.grade] += 1
        }
    }

    private fun calculateRankWithBonus(bonus: Boolean): Int {
        return if (bonus) Rank.FIVE_MATCH_WITH_BONUS.grade else Rank.FIVE_MATCH.grade
    }
}