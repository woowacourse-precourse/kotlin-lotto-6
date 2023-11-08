package lotto.controller

import lotto.model.PurchaseAmount
import lotto.util.HandleException
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView, private val handleException: HandleException) {
    fun run() {
        val purchaseAmount: PurchaseAmount = handleException.tryUntilSuccess {receiveAmount()}
        val lottoCnt = printPurchasedLotto(purchaseAmount.lottoCnt)
    }

    private fun receiveAmount() : PurchaseAmount {
        outputView.outputAmount()
        return PurchaseAmount(inputView.inputAmount())
    }

    private fun printPurchasedLotto(lottoCnt: Int) {
        outputView.outputBlankLine()
        outputView.outputLottoCnt(lottoCnt)
    }
}