package lotto.controller

import lotto.models.Purchase
import lotto.views.InputView
import lotto.views.OutputView

class LottoGameController() {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()

    fun start() {
        inputPurchaseAmount()
    }

    private fun inputPurchaseAmount(): Purchase {
        var purchase: Purchase? = null

        while (purchase == null) {
            try {
                val amount = inputView.inputPurchaseAmount()
                purchase = Purchase(amount)
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }

        return purchase
    }
}