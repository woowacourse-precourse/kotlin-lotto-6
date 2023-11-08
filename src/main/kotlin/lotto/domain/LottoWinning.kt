package lotto.domain

import lotto.presentation.LottoWinningView.outputFiveBonusWinningResult
import lotto.presentation.LottoWinningView.outputFiveWinningResult
import lotto.presentation.LottoWinningView.outputFourWinningResult
import lotto.presentation.LottoWinningView.outputSixWinningResult
import lotto.presentation.LottoWinningView.outputThreeWinningResult

class LottoWinning(private val winningCount: MutableList<Int>, private val bonusCount: Int) {
    private val threeCount = winningCount.count { it == 3 }
    private val fourCount = winningCount.count { it == 4 }
    private val fiveCount = winningCount.count { it == 5 }
    private val sixCount = winningCount.count { it == 6 }
    private val count = fiveCount.minus(bonusCount)

    fun calculate() {
        outputThreeWinningResult(threeCount)
        outputFourWinningResult(fourCount)
        outputFiveWinningResult(count)
        outputFiveBonusWinningResult(bonusCount)
        outputSixWinningResult(sixCount)
    }

    fun profit(amount: Int): String {
        val first = 2000000000 * sixCount
        val second = 30000000 * bonusCount
        val third = 1500000 * count
        val fourth = 50000 * fourCount
        val fifth = 5000 * threeCount
        val total = first + second + third + fourth + fifth
        return String.format("%.1f", total.toDouble() / amount * 100) + "%"
    }
}