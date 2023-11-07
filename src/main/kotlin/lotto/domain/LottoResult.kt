package lotto.domain

import lotto.constants.Constants.FORMAT_ONE_DECIMAL_PLACE
import lotto.constants.Constants.LOTTO_PRICE
import lotto.constants.Constants.PERCENTILE

class LottoResult(
    private val lotties: List<List<Int>>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    fun getFinalResult(): FinalResult {
        val winningData = getWinningData()
        val rateOfReturn = getRateOfReturn(winningData)

        return FinalResult(winningData, rateOfReturn)
    }

    private fun getWinningData(): Map<Rank, Int> {
        val winningData = mutableMapOf<Rank, Int>()
        val resultRankData = lotties.mapNotNull {
            getResultForEachLotto(it)
        }

        val ranks = Rank.entries.toTypedArray()

        for (rank in ranks) {
            winningData[rank] = resultRankData.count { it == rank }
        }

        return winningData
    }

    fun getRateOfReturn(winningData: Map<Rank, Int>): String {
        val purchasedAmount = lotties.size * LOTTO_PRICE.toDouble()
        val earnedAmount = winningData.entries.sumOf { (rank, count) ->
            rank.reward * count
        }.toDouble()

        return FORMAT_ONE_DECIMAL_PLACE.format(earnedAmount / purchasedAmount * PERCENTILE)
    }

    fun getResultForEachLotto(lotto: List<Int>): Rank? {
        val winningCount = getWinningCount(lotto)
        val containsBonus = getContainsBonusOrNot(lotto)

        return when (winningCount) {
            3 -> Rank.FIFTH
            4 -> Rank.FOURTH
            5 -> if (!containsBonus) Rank.THIRD else Rank.SECOND
            6 -> Rank.FIRST
            else -> null
        }
    }

    fun getWinningCount(lotto: List<Int>): Int {
        var winningCount = 0
        lotto.onEach {
            if (it in winningNumbers) winningCount++
        }

        return winningCount
    }

    fun getContainsBonusOrNot(lotto: List<Int>): Boolean = bonusNumber in lotto

}