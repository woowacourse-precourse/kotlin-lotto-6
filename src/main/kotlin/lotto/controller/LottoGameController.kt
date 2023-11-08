package lotto.controller

import lotto.models.Lotto
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

        outputView.printPurchasedLottos(purchasedLottos)

        val winningLotto = inputWinningLottoNumbers()

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

        inputView.endInput()

        return purchase.getAmount()
    }

    private fun inputWinningLottoNumbers(): Lotto {
        var lotto: Lotto? = null

        while (lotto == null) {
            try {
                val numbers = inputView.inputWinningNumbers()
                lotto = Lotto(numbers)
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message)
            }
        }

        inputView.endInput()

        return lotto
    }
}