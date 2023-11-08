package lotto

import java.text.DecimalFormat

enum class Jackpot(
    val countMatches: Int,
    val jackpot: Double,
    val bonusMatch: Boolean = false,
) {

    FIFTH(3, 5_000.0),
    FOURTH(4, 50_000.0),
    THIRD(5, 1_500_000.0),
    SECOND(5, 30_000_000.0, true),
    FIRST(6, 2_000_000_000.0);

    companion object {
        fun findByMatchInfo(count: Int, bonus: Boolean): Jackpot? {
            return entries.find { it.countMatches == count && (it.bonusMatch == bonus || (!it.bonusMatch && !bonus)) }
        }

        fun format(amount: Double): String {
            return DecimalFormat("#,###").format(amount)
        }
    }

}