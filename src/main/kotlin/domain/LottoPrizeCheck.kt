package domain

import model.Winning

class LottoPrizeCheck(
    private val jackpotNumbers: List<Int>,
    private val lotto: Lotto
) {
    fun checkPrize(): Int = when (jackpotNumbers.intersect(lotto.getNumbers()).size) {
        MATCH_SIX_NUMBERS -> FIRST_PLACE_INDEX
        MATCH_FIVE_NUMBERS -> if (containsBonusNumber()) SECOND_PLACE_INDEX else THIRD_PLACE_INDEX
        MATCH_FOUR_NUMBERS -> FOURTH_PLACE_INDEX
        MATCH_THREE_NUMBERS -> FOURTH_FIFTH
        else -> NO_LUCK
    }

    private fun containsBonusNumber(): Boolean = lotto.getNumbers().contains(jackpotNumbers.last())

    companion object {
        const val MATCH_THREE_NUMBERS = 3
        const val MATCH_FOUR_NUMBERS = 4
        const val MATCH_FIVE_NUMBERS = 5
        const val MATCH_SIX_NUMBERS = 6

        const val FIRST_PLACE_INDEX = 0
        const val SECOND_PLACE_INDEX = 1
        const val THIRD_PLACE_INDEX = 2
        const val FOURTH_PLACE_INDEX = 3
        const val FOURTH_FIFTH = 4
        const val NO_LUCK = -1
    }
}