package lotto

class LottoWinResult {

    private var money: Long = 0L
    private val ranks = mutableListOf(0, 0, 0, 0, 0, 0)

    fun getTotalMoney(): Long = money
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

    fun addPrizeMoney(ball: Int, bonus: Boolean) {
        money += when (ball) {
            6 -> Rank.ALL_MATCH.prize
            5 -> calculatePrizeMoneyWithBonus(bonus)
            4 -> Rank.FOUR_MATCH.prize
            3 -> Rank.THREE_MATCH.prize
            else -> Rank.NOT_MATCH.prize
        }
    }

    fun calculateRateOfProfit(price: Int, prizeMoney: Long): Double =
        if (prizeMoney == 0L) 0.0 else (prizeMoney.toDouble() / price.toDouble()) * 100.0

    private fun calculateRankWithBonus(bonus: Boolean): Int {
        return if (bonus) Rank.FIVE_MATCH_WITH_BONUS.grade else Rank.FIVE_MATCH.grade
    }

    private fun calculatePrizeMoneyWithBonus(bonus: Boolean): Int {
        return if (bonus) Rank.FIVE_MATCH_WITH_BONUS.prize else Rank.FIVE_MATCH.prize
    }
}