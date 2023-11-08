package lotto

import lotto.data.Lotto
import lotto.data.Money
import lotto.data.Winning
import lotto.data.WinningResult

class WinningResultGenerator {

    fun get(
        lotteryTickets: List<Lotto>,
        winning: Winning,
        money: Money
    ) = getWinningResultFrom(lotteryTickets, winning, money)

    private fun getWinningResultFrom(
        lotteryTickets: List<Lotto>,
        winning: Winning,
        money: Money
    ): WinningResult {
        val winningCounts = calculatedWinningCounts(lotteryTickets, winning)
        val margin = calculatedMargin(winningCounts, money)

        return WinningResult(winningCounts, margin)
    }

    private fun calculatedWinningCounts(
        lotteryTickets: List<Lotto>,
        winning: Winning
    ): List<Int> {
        val counts = MutableList(CASE_TYPE_COUNT) { 0 }

        lotteryTickets.map {
            if (calculateWinningCount(it, winning) == THREE) counts[0]++
            if (calculateWinningCount(it, winning) == FOUR) counts[1]++
            if (calculateWinningCount(it, winning) == FIVE) {
                if (!checkHasBonus(it, winning)) counts[2]++
                else counts[3]++
            }
            if (calculateWinningCount(it, winning) == SIX) counts[4]++
        }

        return counts
    }

    private fun calculatedMargin(winningCounts: List<Int>, money: Money): Double {
        var total = 0.0

        total += winningCounts[0] * Constants.CASE_1_WINNINGS
        total += winningCounts[1] * Constants.CASE_2_WINNINGS
        total += winningCounts[2] * Constants.CASE_3_WINNINGS
        total += winningCounts[3] * Constants.CASE_4_WINNINGS
        total += winningCounts[4] * Constants.CASE_5_WINNINGS

        return total / money.number
    }

    private fun calculateWinningCount(lotto: Lotto, winning: Winning): Int {
        return lotto.getNumbers().intersect(winning.numbers).size
    }

    private fun checkHasBonus(lotto: Lotto, winning: Winning): Boolean {
        return lotto.getNumbers().contains(winning.bonus)
    }

    companion object {
        private const val CASE_TYPE_COUNT = 5
        private const val THREE = 3
        private const val FOUR = 4
        private const val FIVE = 5
        private const val SIX = 6
    }
}