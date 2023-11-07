package lotto.domain

enum class LottoRank(val matchCount: Int, val hasBonus: Boolean, val prizeMoney: String) {
    NONE(0, false, "0"),
    FIFTH(3, false, "5,000"),
    FOURTH(4, false, "50,000"),
    THIRD(5, false, "1,500,000"),
    SECOND(5, true, "30,000,000"),
    FIRST(6, false, "2,000,000,000");

    companion object {
        fun getRank(matchCount: Int, hasBonus: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}
