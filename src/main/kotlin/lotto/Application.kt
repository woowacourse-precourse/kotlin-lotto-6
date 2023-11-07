package lotto

import lotto.domain.LottoPurchase
import lotto.domain.WinningNumberGenerator
import lotto.domain.WinningStatistics
import lotto.ui.Output

fun main() {
    startLotto()
}

fun startLotto() {
    val purchaseLotto = LottoPurchase()
    val lotteryNumber = purchaseLotto.inputAmount()
    Output.printLotteryNumber(lotteryNumber)
    val lottos = purchaseLotto.buyLottos(lotteryNumber)
    Output.printLottos(lottos)
    val winningNumberGenerator = WinningNumberGenerator()
    val winningNumber = winningNumberGenerator.inputWinningNumber()
    val bonusNumber = winningNumberGenerator.inputBonusNumber(winningNumber)
    val winningStatistics = WinningStatistics()
    val winningDetails = winningStatistics.getWinningDetails(lottos, winningNumber, bonusNumber)
    Output.printWinningStatistics(winningDetails)
    val rateOfReturn = winningStatistics.getRateOfReturn(lotteryNumber, winningDetails)
    Output.printRateOfReturn(rateOfReturn)
}
