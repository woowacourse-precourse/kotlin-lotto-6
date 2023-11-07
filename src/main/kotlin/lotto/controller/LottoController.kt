package lotto.controller

import lotto.model.PurchaseAmount
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    private val inputView = InputView()
    private val outputView = OutputView()
    fun startGame() {
        val inputPurchaseAmount = inputView.promptPurchaseAmount()
        val purchaseAmount = PurchaseAmount(inputPurchaseAmount)
        println(purchaseAmount)
    }
}