package lotto.domain.model

import lotto.util.Constants

enum class Rank(val prize: String, val hasBonusNumber: Boolean, val maxMatchWinningNumber: Int) {
    FIRST_PLACE("2,000,000,000", false, 6),
    SECOND_PLACE("30,000,000", true, 5),
    THIRD_PLACE("1,500,000", false, 5),
    FOURTH_PLACE("50,000", false, 4),
    FIFTH_PLACE("5,000", false, 3),
    NONE("0", false, 2),
    ;

    fun getPrize(): Int = prize.replace(Constants.COMMA, Constants.BLANK).toInt()

    companion object {
        fun getList() = listOf(FIFTH_PLACE, FOURTH_PLACE, THIRD_PLACE, SECOND_PLACE, FIRST_PLACE)
        fun getPlace(count: Int, isBonusNumber: Boolean) =
            when (count) {
                3 -> FIFTH_PLACE
                4 -> SECOND_PLACE
                5 -> THIRD_PLACE
                6 -> {
                    if (isBonusNumber) {
                        SECOND_PLACE
                    }
                    FIRST_PLACE
                }

                else -> NONE
            }
    }
}
