package lotto.domain

import lotto.constant.LottoRank
import lotto.constant.PrintText
import java.util.*

class LottoGameResult {
    private val allSameCount: MutableMap<LottoRank, Int> = EnumMap(LottoRank::class.java)

    init {
        for (sameCount in LottoRank.entries) {
            allSameCount[sameCount] = INIT_SAME_COUNT
        }
    }

    fun calculateResult(sameCount: Int, bonus: Int) {
        val sameTotalCount = sameCount + bonus
        if (sameTotalCount < MIN_WINNING_COUNT) {
            return
        }
        saveResult(sameTotalCount, bonus)
    }

    private fun saveResult(sameTotalCount: Int, bonus: Int) {
        if (bonus == INIT_SAME_COUNT && sameTotalCount == MAX_WINNING_COUNT) {
            allSameCount[LottoRank.FIRST_PLACE] =
                allSameCount[LottoRank.FIRST_PLACE]!! + PLUS_WINNING_COUNT
            return
        }
        saveExceptSixResult(sameTotalCount, bonus)
    }

    private fun saveExceptSixResult(sameTotalCount: Int, bonus: Int) {
        if (bonus == BONUS_NUMBER_SAME && sameTotalCount == MAX_WINNING_COUNT) {
            allSameCount[LottoRank.SECOND_PLACE] =
                allSameCount[LottoRank.SECOND_PLACE]!! + PLUS_WINNING_COUNT
            return
        }
        saveExceptTopTwoResult(sameTotalCount)
    }

    private fun saveExceptTopTwoResult(sameTotalCount: Int) {
        if (sameTotalCount == MIN_WINNING_COUNT) {
            allSameCount[LottoRank.FIFTH_PLACE] =
                allSameCount[LottoRank.FIFTH_PLACE]!! + PLUS_WINNING_COUNT
            return
        }
        saveOtherResult(sameTotalCount)
    }

    private fun saveOtherResult(sameTotalCount: Int) {
        if (sameTotalCount == WINNING_COUNT_FOUR) {
            allSameCount[LottoRank.FOURTH_PLACE] =
                allSameCount[LottoRank.FOURTH_PLACE]!! + PLUS_WINNING_COUNT
            return
        }

        if (sameTotalCount == WINNING_COUNT_FIVE) {
            allSameCount[LottoRank.THIRD_PLACE] =
                allSameCount[LottoRank.THIRD_PLACE]!! + PLUS_WINNING_COUNT
        }
    }

    fun toAllSameCountResult(): String {
        val sb = StringBuilder()

        return toSameNumberCountsResult(sb)
    }

    private fun toSameNumberCountsResult(
        sb: StringBuilder
    ): String {
        for (sameNumberCount in SAME_NUMBER_COUNTS) {
            sb.append(
                sameNumberCount.key.text + PrintText.SEPARATE_SAME_COUNT.text
                        + allSameCount[sameNumberCount.key] + PrintText.SAME_NUMBER_COUNT.text + PrintText.SEPARATE_LOTTES.text
            )
        }
        return sb.toString()
    }

    fun calculateEarningRate(purchaseAmount: Int): String {
        var earningRate = 0.0
        for (sameNumberCount in SAME_NUMBER_COUNTS) {
            earningRate += allSameCount[sameNumberCount.key]!! * sameNumberCount.value
        }
        return PrintText.PRINT_EARNING_RATE.text + String.format(
            PERCENT_FORMAT,
            (earningRate / purchaseAmount) * PERCENT_VALUE
        ) + PrintText.PRINT_PERCENT.text
    }

    companion object {
        private const val INIT_SAME_COUNT = 0
        private const val MIN_WINNING_COUNT = 3
        private const val WINNING_COUNT_FOUR = 4
        private const val WINNING_COUNT_FIVE = 5
        private const val MAX_WINNING_COUNT = 6
        private const val BONUS_NUMBER_SAME = 1
        private const val PLUS_WINNING_COUNT = 1
        private const val PERCENT_VALUE = 100
        private const val WINNING_COUNT_THREE_WINNINGS = 5000
        private const val WINNING_COUNT_FOUR_WINNINGS = 50000
        private const val WINNING_COUNT_FIVE_WINNINGS = 1500000
        private const val WINNING_COUNT_FIVE_WITH_BONUS_WINNINGS = 30000000
        private const val WINNING_COUNT_SIX_WINNINGS = 2000000000
        private const val PERCENT_FORMAT = "%.1f"
        private val SAME_NUMBER_COUNTS = mapOf(
            LottoRank.FIFTH_PLACE to WINNING_COUNT_THREE_WINNINGS,
            LottoRank.FOURTH_PLACE to WINNING_COUNT_FOUR_WINNINGS,
            LottoRank.THIRD_PLACE to WINNING_COUNT_FIVE_WINNINGS,
            LottoRank.SECOND_PLACE to WINNING_COUNT_FIVE_WITH_BONUS_WINNINGS,
            LottoRank.FIRST_PLACE to WINNING_COUNT_SIX_WINNINGS
        )
    }
}