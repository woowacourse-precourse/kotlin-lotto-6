package lotto.controller

import lotto.model.PurchaseAmount
import lotto.util.HandleException
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView, private val handleException: HandleException) {
    fun run() {
        val purchaseAmount: PurchaseAmount = receiveAmount()
    }

    private fun receiveAmount() : PurchaseAmount {
        outputView.outputAmount()
        return PurchaseAmount(inputView.inputAmount())
    }
}