package lotto

class LottoPrizeCalculator {
    private var lottoNumberMatch = INITIAL_NUM
    private var bonusNumberMatch = false

    companion object {
        private const val INITIAL_NUM = 0
        private const val SIX_MATCH_PRIZE = 2_000_000_000
        private const val FIVE_AND_BONUS_MATCH_PRIZE = 30_000_000
        private const val FIVE_MATCH_PRIZE = 1_500_000
        private const val FOUR_MATCH_PRIZE = 50_000
        private const val THREE_MATCH_PRIZE = 5_000
    }
    fun calculatePrizesAndReturnTotalPrize(lottoPurchaseCounts: List<List<Int>>, winningLotteryNumbers: List<Int>, bonusNumber: Int, prizeCounts: IntArray): Int {
        var totalPrize = INITIAL_NUM

        for (i in INITIAL_NUM until lottoPurchaseCounts.size) {
            val union = lottoPurchaseCounts[i] + winningLotteryNumbers
            val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
            lottoNumberMatch = intersection.size
            bonusNumberMatch = lottoPurchaseCounts[i].contains(bonusNumber)

            changeNumberMatch()

            totalPrize += calculatePrizeAndIncrementCount(lottoNumberMatch, prizeCounts)

        }
        return totalPrize
    }

    private fun changeNumberMatch() {
        if (bonusNumberMatch && lottoNumberMatch == 4) {
            bonusNumberMatch = false
            lottoNumberMatch++
        }
        if (bonusNumberMatch && lottoNumberMatch != 5) {
            lottoNumberMatch++
        }

    }

    private fun calculatePrizeAndIncrementCount(
            lottoNumberMatch: Int,
            prizeCounts: IntArray
    ): Int {
        val prizeIndex = when (lottoNumberMatch) {
            6 -> 4
            5 -> if (bonusNumberMatch) 3 else 2
            4 -> 1
            3 -> 0
            else -> -1
        }

        if (prizeIndex >= INITIAL_NUM) {
            prizeCounts[prizeIndex]++
            return calculatePrizeForMatch(lottoNumberMatch)
        }

        return INITIAL_NUM
    }

    private fun calculatePrizeForMatch(lottoNumberMatch: Int): Int {
        return when (lottoNumberMatch) {
            6 -> SIX_MATCH_PRIZE
            5 -> if (bonusNumberMatch) FIVE_AND_BONUS_MATCH_PRIZE else FIVE_MATCH_PRIZE
            4 -> FOUR_MATCH_PRIZE
            3 -> THREE_MATCH_PRIZE
            else -> INITIAL_NUM
        }
    }
}