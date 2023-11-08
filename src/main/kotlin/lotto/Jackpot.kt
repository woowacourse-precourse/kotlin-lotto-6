package lotto

enum class Jackpot(
    val countMatches: Int,
    val jackpot: Double,
    val bonusMatch: Boolean = false,
) {
    FIRST(6, 2_000_000_000.0),
    SECOND(5, 30_000_000.0, true),
    THIRD(5, 1_500_000.0),
    FOURTH(4, 50_000.0),
    FIFTH(3, 5_000.0);

    companion object {
        fun findByMatchInfo(count: Int, bonus: Boolean): Jackpot? {
            return entries.find { it.countMatches == count && (!it.bonusMatch || it.bonusMatch == bonus) }
        }
    }
}