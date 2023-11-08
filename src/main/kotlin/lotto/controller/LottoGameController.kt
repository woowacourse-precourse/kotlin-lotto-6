package lotto.controller

import lotto.models.Publisher
import lotto.models.Purchase
import lotto.views.InputView
import lotto.views.OutputView

class LottoGameController() {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()

    fun start() {
        val publisher = Publisher()

        val purchaseAmount = inputPurchaseAmount()
        val purchasedLottos = publisher.publishLottos(purchaseAmount)
    }

    private fun inputPurchaseAmount(): Int {
        var purchase: Purchase? = null

        while (purchase == null) {
            try {
                val amount = inputView.inputPurchaseAmount()
                purchase = Purchase(amount)
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }

        return purchase.getAmount()
    }

}