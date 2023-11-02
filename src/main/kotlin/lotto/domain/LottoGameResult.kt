package lotto.domain

import lotto.constant.ExtraText
import lotto.constant.PrintText

class LottoGameResult {
    private val allSameCount = mutableMapOf<Int, Int>()

    init {
        allSameCount[WINNING_COUNT_THREE_WINNINGS] = INIT_SAME_COUNT
        allSameCount[WINNING_COUNT_FOUR_WINNINGS] = INIT_SAME_COUNT
        allSameCount[WINNING_COUNT_FIVE_WINNINGS] = INIT_SAME_COUNT
        allSameCount[WINNING_COUNT_FIVE_WITH_BONUS_WINNINGS] = INIT_SAME_COUNT
        allSameCount[WINNING_COUNT_SIX_WINNINGS] = INIT_SAME_COUNT
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
            allSameCount[WINNING_COUNT_SIX_WINNINGS] =
                allSameCount[WINNING_COUNT_SIX_WINNINGS]!! + PLUS_WINNING_COUNT
            return
        }
        saveExceptSixResult(sameTotalCount, bonus)
    }

    private fun saveExceptSixResult(sameTotalCount: Int, bonus: Int) {
        if (bonus == BONUS_NUMBER_SAME && sameTotalCount == MAX_WINNING_COUNT) {
            allSameCount[WINNING_COUNT_FIVE_WITH_BONUS_WINNINGS] =
                allSameCount[WINNING_COUNT_FIVE_WITH_BONUS_WINNINGS]!! + PLUS_WINNING_COUNT
            return
        }
        saveExceptTopTwoResult(sameTotalCount)
    }

    private fun saveExceptTopTwoResult(sameTotalCount: Int) {
        if (sameTotalCount == MIN_WINNING_COUNT) {
            allSameCount[WINNING_COUNT_THREE_WINNINGS] =
                allSameCount[WINNING_COUNT_THREE_WINNINGS]!! + PLUS_WINNING_COUNT
            return
        }
        saveOtherResult(sameTotalCount)
    }

    private fun saveOtherResult(sameTotalCount: Int) {
        if (sameTotalCount == WINNING_COUNT_FOUR) {
            allSameCount[WINNING_COUNT_FOUR_WINNINGS] =
                allSameCount[WINNING_COUNT_FOUR_WINNINGS]!! + PLUS_WINNING_COUNT
            return
        }

        if (sameTotalCount == WINNING_COUNT_FIVE) {
            allSameCount[WINNING_COUNT_FIVE_WINNINGS] =
                allSameCount[WINNING_COUNT_FIVE_WINNINGS]!! + PLUS_WINNING_COUNT
        }
    }

    fun toAllSameCountResult(): String {
        val sb = StringBuilder()
        val sameNumberCounts = mapOf<String, Int>(
            ExtraText.SAME_THREE_NUMBER.text to WINNING_COUNT_THREE_WINNINGS,
            ExtraText.SAME_FOUR_NUMBER.text to WINNING_COUNT_FOUR_WINNINGS,
            ExtraText.SAME_FIVE_NUMBER.text to WINNING_COUNT_FIVE_WINNINGS,
            ExtraText.SAME_FIVE_NUMBER_WITH_BONUS.text to WINNING_COUNT_FIVE_WITH_BONUS_WINNINGS,
            ExtraText.SAME_SIX_NUMBER.text to WINNING_COUNT_SIX_WINNINGS
        )
        return toSameNumberCountsResult(sameNumberCounts, sb)
    }

    private fun toSameNumberCountsResult(
        sameNumberCounts: Map<String, Int>,
        sb: StringBuilder
    ): String {
        for (sameNumberCount in sameNumberCounts) {
            sb.append(
                sameNumberCount.key + PrintText.SEPARATE_SAME_COUNT.text
                        + allSameCount[sameNumberCount.value] + PrintText.SEPARATE_LOTTES.text
            )
        }
        return sb.toString()
    }

    fun calculateEarningRate(purchaseAmount: Int): String {
        var earningRate = 0.0
        allSameCount.forEach {
            earningRate += it.key * it.value
        }
        return PrintText.PRINT_EARNING_RATE.text + String.format(
            "%.1f",
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
    }
}