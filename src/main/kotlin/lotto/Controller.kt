package lotto

import lotto.domain.LottoBuyer
import lotto.domain.PrizeCalculator
import lotto.io.Input
import lotto.io.Output

class Controller {
    val budget by lazy { Input.getBudget() }
    val lottoBuyer by lazy { LottoBuyer(budget) }
    val lottoList by lazy { lottoBuyer.lottoList }
    val winningNumber by lazy { Input.getWinningNumber() }
    val bonusNumber by lazy { Input.getBonusNumber(winningNumber) }
    val prizeCalculator by lazy { PrizeCalculator(lottoList, winningNumber, bonusNumber) }
    val sumOfWinningPrize by lazy { prizeCalculator.getSumOfWinningPrize() }
    val rate by lazy { Rate(sumOfWinningPrize, budget, 10) }
    fun play() {
        with(Output) {
            printPleaseInputBudget()
            // budget
            printHowMuchBought(lottoBuyer.amountOfLotto)
            printListOfLottoNumbers(lottoList)
            printPleaseInputWinningNumbers()
            winningNumber
            printPleaseInputBonusNumbers()
            bonusNumber
            printWinningStatistics(prizeCalculator.getWinningCountMap())
            printProfitRate(rate)
        }
    }
}
