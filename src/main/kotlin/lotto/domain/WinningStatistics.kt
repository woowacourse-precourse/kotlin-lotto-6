package lotto.domain

import lotto.constants.AMOUNT_UNIT
import lotto.constants.MATCH_FIVE_AND_BONUS_MONEY
import lotto.constants.MATCH_FIVE_MONEY
import lotto.constants.MATCH_FOUR_MONEY
import lotto.constants.MATCH_SIX_MONEY
import lotto.constants.MATCH_THREE_MONEY

enum class Match(val value: Int) {
    THREE(0), FOUR(1), FIVE(2), FIVE_AND_BONUS(3), SIX(4)
}

class WinningStatistics {
    fun getWinningDetails(
        lottos: MutableList<Lotto>,
        winningNumber: List<Int>,
        bonusNumber: Int
    ): MutableList<Int> {
        val winningDetails = MutableList(5) { 0 }

        for (lotto in lottos) {
            val matchNumber = winningNumber.count { lotto.getLotto().contains(it) }
            val isBonusNumberMatching = lotto.getLotto().contains(bonusNumber)

            when (matchNumber) {
                3 -> winningDetails[Match.THREE.value]++
                4 -> winningDetails[Match.FOUR.value]++
                5 -> if (isBonusNumberMatching) winningDetails[Match.FIVE_AND_BONUS.value]++ else winningDetails[Match.FIVE.value]++
                6 -> winningDetails[Match.SIX.value]++
                else -> null
            }
        }
        return winningDetails
    }

    fun getRateOfReturn(lotteryNumber: Int, winningDetails: MutableList<Int>): String {
        val matchThree = winningDetails[Match.THREE.value] * MATCH_THREE_MONEY
        val matchFour = winningDetails[Match.FOUR.value] * MATCH_FOUR_MONEY
        val matchFive = winningDetails[Match.FIVE.value] * MATCH_FIVE_MONEY
        val matchFiveAndBonus =
            winningDetails[Match.FIVE_AND_BONUS.value] * MATCH_FIVE_AND_BONUS_MONEY
        val matchSix = winningDetails[Match.SIX.value] * MATCH_SIX_MONEY
        val total = matchThree + matchFour + matchFive + matchFiveAndBonus + matchSix
        val result = total * 100 / (lotteryNumber * AMOUNT_UNIT).toDouble()
        return "%.1f".format(result)
    }
}