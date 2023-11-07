package lotto.model

enum class LottoPrize(val prizeCount: Int, val money: Int, val bonus: Boolean) {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NOTTING(0, 0, false);

    companion object {
        fun getLottoPrize(prizeCount: Int, bonus: Boolean): LottoPrize {
            return entries.firstOrNull { it.prizeCount == prizeCount && it.bonus == bonus } ?: return NOTTING
        }
    }

}