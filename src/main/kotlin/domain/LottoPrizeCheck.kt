package domain

class LottoPrizeCheck(
    private val jackpotNumbers: List<Int>,
    private val lotto: Lotto
) {
    fun checkPrize(): Int = when (jackpotNumbers.intersect(lotto.getNumbers()).size) {
        MATCH_SIX_NUMBERS -> INDEX_OF_FOURTH
        MATCH_FIVE_NUMBERS -> if (containsBonusNumber()) INDEX_OF_THIRD else INDEX_OF_SECOND
        MATCH_FOUR_NUMBERS -> INDEX_OF_FIRST
        MATCH_THREE_NUMBERS -> INDEX_OF_ZERO
        else -> INDEX_NOTHING
    }

    private fun containsBonusNumber(): Boolean = lotto.getNumbers().contains(jackpotNumbers.last())

    companion object {
        private const val MATCH_THREE_NUMBERS = 3
        private const val MATCH_FOUR_NUMBERS = 4
        private const val MATCH_FIVE_NUMBERS = 5
        private const val MATCH_SIX_NUMBERS = 6

        private const val INDEX_OF_ZERO = 0
        private const val INDEX_OF_FIRST = 1
        private const val INDEX_OF_SECOND = 2
        private const val INDEX_OF_THIRD = 3
        private const val INDEX_OF_FOURTH = 4
        const val INDEX_NOTHING = -1
    }
}