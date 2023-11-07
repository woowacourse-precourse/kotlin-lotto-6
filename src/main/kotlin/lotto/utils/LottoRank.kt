package lotto.utils

enum class LottoRank(val numberMatch: Int, val prize: Int, val bonusNumber: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    companion object {
        fun matchRank(numberMatch: Int, bonusNumber: Boolean): LottoRank {
            if (numberMatch == 5) {
                return entries.firstOrNull { it.numberMatch == numberMatch && it.bonusNumber == bonusNumber } ?: MISS
            }
            return entries.firstOrNull { it.numberMatch == numberMatch } ?: MISS
        }
    }
}