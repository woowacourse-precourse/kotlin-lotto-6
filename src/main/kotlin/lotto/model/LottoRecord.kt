package lotto.model

enum class LottoRecord(val match: Int, val reward: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    companion object {
        fun makeRewardStatistics(match: Int, isBonusMatch: Boolean): LottoRecord =
            when (match) {
                3 -> FIFTH
                4 -> FOURTH
                5 -> if (isBonusMatch) SECOND else THIRD
                6 -> FIRST
                else -> NONE
            }
    }


}


