package lotto.domain

enum class LottoWinResult(
    val grade: Int,
    val prize: Int
) {
    ALL_MATCH(1, 2_000_000_000),
    FIVE_MATCH_WITH_BONUS(2, 30_000_000),
    FIVE_MATCH(3, 1_500_000),
    FOUR_MATCH(4, 50_000),
    THREE_MATCH(5, 5_000),
    NOT_MATCH(0, 0);

    companion object {
        private val ranks = mutableListOf(0, 0, 0, 0, 0, 0)
        private var money: Long = 0L

        fun getRanks(): List<Int> = ranks.toList()
        fun getMoney(): Long = this.money

        fun calculateRank(ball: Int, bonus: Boolean) {
            when (ball) {
                6 -> ranks[ALL_MATCH.grade] += 1
                5 -> ranks[calculateRankOrMoneyWithBonus(bonus)] += 1
                4 -> ranks[FOUR_MATCH.grade] += 1
                3 -> ranks[THREE_MATCH.grade] += 1
                else -> ranks[NOT_MATCH.grade] += 1
            }
        }

        fun addPrizeMoney(ball: Int, bonus: Boolean) {
            money += when (ball) {
                6 -> ALL_MATCH.prize
                5 -> calculateRankOrMoneyWithBonus(bonus)
                4 -> FOUR_MATCH.prize
                3 -> THREE_MATCH.prize
                else -> NOT_MATCH.prize
            }
        }

        fun calculateRateOfProfit(price: Int, prizeMoney: Long): Double =
            if (prizeMoney == 0L) 0.0 else (prizeMoney.toDouble() / price.toDouble()) * 100.0

        private fun calculateRankOrMoneyWithBonus(bonus: Boolean): Int {
            return if (bonus) FIVE_MATCH_WITH_BONUS.grade else FIVE_MATCH.grade
        }
    }
}