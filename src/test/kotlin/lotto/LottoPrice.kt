package lotto

enum class LottoPrice(val numberMatch: Int, val prize: Int, val bonusNumber: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    companion object {
        fun matchPrice(numberMatch: Int, bonusNumber: Boolean): LottoPrice {
            return entries.first{it.numberMatch==numberMatch && it.bonusNumber==bonusNumber}
        }
    }
}