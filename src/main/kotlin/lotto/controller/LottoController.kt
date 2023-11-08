package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoStore
import lotto.domain.WinningLotto
import lotto.utils.PurchaseAmountCalculator
import lotto.view.LottoIssueView
import lotto.view.LottoPurchaseView
import lotto.view.WinningLottoView
import lotto.view.WinningStatisticsView

class LottoController {
  fun startLotto() {
    val purchaseMoney = purchaseLotto()
    println()
    val purchaseAmount = PurchaseAmountCalculator.calculatePurchaseAmount(purchaseMoney)
    val lottoStore = LottoStore()
    val lottos = lottoStore.sellIssuedLottos(purchaseAmount)
    showIssuedLottos(purchaseAmount, lottos)
    val winningNumbers = getWinningNumbers()
    println()
    val bonusNumber = getBonusNumber()
    println()
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)
    compareAllLottosWithWinningLotto(lottos, winningLotto)
    showTotalProfitRate(purchaseMoney, winningLotto)
  }

  private fun purchaseLotto(): Long {
    LottoPurchaseView.printPurchaseMoneyInputMessage()
    return LottoPurchaseView.inputPurchaseMoney()
  }

  private fun showIssuedLottos(purchaseAmount: Int, lottos: List<Lotto>) {
    LottoIssueView.printIssuedAmountMessage(purchaseAmount)
    LottoIssueView.printIssuedLotto(lottos)
  }

  private fun getWinningNumbers(): List<Int> {
    WinningLottoView.printWinningNumbersInputMessage()
    return WinningLottoView.inputWinningNumbers()
  }

  private fun getBonusNumber(): List<Int> {
    WinningLottoView.printBonusNumberInputMessage()
    return WinningLottoView.inputBonusNumber()
  }

  private fun compareAllLottosWithWinningLotto(lottos: List<Lotto>, winningLotto: WinningLotto) {
    for (lotto in lottos) {
      winningLotto.compareLottos(lotto)
    }
  }

  private fun showTotalProfitRate(purchaseMoney: Long, winningLotto: WinningLotto) {
    WinningStatisticsView.printWinningsStatistics()
    val profitRate = winningLotto.calculateProfitRate(purchaseMoney)
    WinningStatisticsView.printTotalProfitRate(profitRate)
  }
}