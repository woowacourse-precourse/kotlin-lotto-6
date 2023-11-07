package lotto

import lotto.io.input.Input
import lotto.io.output.Output
import lotto.model.*
import lotto.model.lotto.Lotto
import lotto.service.LottoSupplier
import lotto.model.lotto.PurchaseLottos
import lotto.model.lotto.WinningLotto
import lotto.service.WinningCalculator
import lotto.utils.retryWhileNoException

class LottoController(
    private val input: Input,
    private val output: Output,
    private val lottoSupplier: LottoSupplier,
    private val winningCalculator: WinningCalculator
) {

    private val purchaseInfo: PurchaseInfo by lazy { readyPurchaseInfo() }
    private val purchaseLottos: PurchaseLottos by lazy { readyPurchaseLottos() }
    private val winningLotto: WinningLotto by lazy { readyWinningLotto() }

    private fun readyPurchaseInfo(): PurchaseInfo {
        val purchaseInfo = retryWhileNoException {
            output.printInputPurchaseAmount()
            val purchaseInfo = input.inputPurchaseAmount()
            PurchaseInfo(purchaseInfo.amount)
        } as PurchaseInfo

        output.printPurchaseCount(purchaseInfo.count)
        return purchaseInfo
    }

    private fun readyPurchaseLottos() =
        lottoSupplier.supplyPurchaseLottos(purchaseInfo.count).also {
            output.printLottos(it)
        }

    private fun readyWinningLotto(): WinningLotto {
        val winningLotto = retryWhileNoException {
            output.printInputWinningNumbers()
            input.inputWinningNumbers()
        } as Lotto

        return retryWhileNoException {
            output.printInputBonusNumber()
            val bonus = input.inputBonusNumber()
            WinningLotto(winningLotto, bonus)
        } as WinningLotto
    }

    fun run() {
        val winningResult = winningCalculator.calculateWinningResult(purchaseLottos, winningLotto)
        val totalReturn = winningCalculator.calculateTotalReturn(
            winningResult.winningAmount, purchaseInfo.amount)

        output.printWinningStat(winningResult.winningCounts, totalReturn)
    }
}