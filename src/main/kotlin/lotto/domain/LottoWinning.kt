package lotto.domain

import lotto.presentation.LottoWinningView.outputFiveBonusWinningResult
import lotto.presentation.LottoWinningView.outputFiveWinningResult
import lotto.presentation.LottoWinningView.outputFourWinningResult
import lotto.presentation.LottoWinningView.outputSixWinningResult
import lotto.presentation.LottoWinningView.outputThreeWinningResult

class LottoWinning(private val winningCount: MutableList<Int>, private val bonusCount: Int) {
    fun calculate() {
        val threeCount = winningCount.count { it == 3 }
        val fourCount = winningCount.count { it == 4 }
        val fiveCount = winningCount.count { it == 5 }
        val sixCount = winningCount.count { it == 6 }
        val count = fiveCount.minus(bonusCount)
        outputThreeWinningResult(threeCount)
        outputFourWinningResult(fourCount)
        outputFiveWinningResult(count)
        outputFiveBonusWinningResult(bonusCount)
        outputSixWinningResult(sixCount)
    }
}