package lotto.domain

enum class Rank(
    private val count: Int,
    private val reward: Int,
) {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun checkRank(count: Int, bonusMatch: Boolean): Rank {
            if (count < 3) {
                return NONE
            }
            if (count == 5 && bonusMatch) {
                return SECOND
            }
            for (rank in entries) {
                if (count == rank.count) {
                    return rank
                }
            }
            throw IllegalArgumentException()
        }
    }
}