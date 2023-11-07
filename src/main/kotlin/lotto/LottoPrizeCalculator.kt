package lotto

import java.math.BigDecimal

enum class Prize(val description: String, val amount: BigDecimal) {
    THREE_MATCHES(MessageConstants.THREE_MATCHES, BigDecimal(5000)),
    FOUR_MATCHES(MessageConstants.FOUR_MATCHES, BigDecimal(50000)),
    FIVE_MATCHES(MessageConstants.FIVE_MATCHES, BigDecimal(1500000)),
    FIVE_MATCHES_AND_BONUS_NUMBER_MATCH(MessageConstants.FIVE_MATCHES_AND_BONUS_NUMBER_MATCH, BigDecimal(30000000)),
    SIX_MATCHES(MessageConstants.SIX_MATCHES, BigDecimal(2000000000))
}
class LottoPrizeCalculator {
    private var lottoNumberMatch = 0
    private var bonusNumberMatch = false

    fun calculatePrizesAndReturnTotalPrize(lottoPurchaseCounts: List<List<Int>>, winningLotteryNumbers: List<Int>, bonusNumber: Int, prizeCounts: IntArray): BigDecimal {
        var totalPrize = BigDecimal.ZERO

        for (i in 0 until lottoPurchaseCounts.size) {
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

    private fun calculatePrizeAndIncrementCount(lottoNumberMatch: Int, prizeCounts: IntArray): BigDecimal {
        val prizeIndex = when (lottoNumberMatch) {
            6 -> Prize.SIX_MATCHES
            5 -> if (bonusNumberMatch) Prize.FIVE_MATCHES_AND_BONUS_NUMBER_MATCH else Prize.FIVE_MATCHES
            4 -> Prize.FOUR_MATCHES
            3 -> Prize.THREE_MATCHES
            else -> null
        }

        return if (prizeIndex != null) {
            prizeCounts[prizeIndex.ordinal]++
            prizeIndex.amount
        } else {
            BigDecimal.ZERO
        }
    }

//    private fun calculatePrizeAndIncrementCount(
//            lottoNumberMatch: Int,
//            prizeCounts: IntArray
//    ): Int {
//        val prizeIndex = when (lottoNumberMatch) {
//            6 -> 4
//            5 -> if (bonusNumberMatch) 3 else 2
//            4 -> 1
//            3 -> 0
//            else -> -1
//        }
//
//        if (prizeIndex >= INITIAL_NUM) {
//            prizeCounts[prizeIndex]++
//            return calculatePrizeForMatch(lottoNumberMatch)
//        }
//
//        return INITIAL_NUM
//    }
//
//    private fun calculatePrizeForMatch(lottoNumberMatch: Int): Int {
//        return when (lottoNumberMatch) {
//            6 -> SIX_MATCH_PRIZE
//            5 -> if (bonusNumberMatch) FIVE_AND_BONUS_MATCH_PRIZE else FIVE_MATCH_PRIZE
//            4 -> FOUR_MATCH_PRIZE
//            3 -> THREE_MATCH_PRIZE
//            else -> INITIAL_NUM
//        }
//    }
}