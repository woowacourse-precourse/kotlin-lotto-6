package lotto.model

enum class Winning(val match: Int, val reward: Int) {

    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    companion object {
        fun makeRewardStatistics(match: Int, isBonusMatch: Boolean): Winning =
            when (match) {
                3 -> FIFTH
                4 -> FOURTH
                5 -> if (isBonusMatch) SECOND else THIRD
                6 -> FIRST
                else -> NONE
            }
    }


}


