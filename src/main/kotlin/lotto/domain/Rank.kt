package lotto.domain

enum class Rank(
    private val matchedCount: Int,
    private val prize: Int,
    private val message: String,
) {
    NONE(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    fun getMessage(count: Int): String {
        return "$message${count}개\n"
    }

    fun getPrize(rank: Rank): Int {
        return rank.prize
    }

    companion object {
        fun getRank(matchedCount: Int, bonusMatch: Boolean): Rank {
            return when {
                matchedCount == FIRST.matchedCount -> FIRST
                matchedCount == SECOND.matchedCount && bonusMatch -> SECOND
                matchedCount == THIRD.matchedCount -> THIRD
                matchedCount == FOURTH.matchedCount -> FOURTH
                matchedCount == FIFTH.matchedCount -> FIFTH
                else -> NONE
            }
        }
    }
}