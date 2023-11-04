package lotto.controller

import lotto.model.PurchaseAmount
import lotto.view.InputView
import lotto.view.OutputView

class GameController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun play() {
        set(inputView)
    }

    fun set(inputView: InputView) {
        val userInputData = inputView.purchaseAmountPrompt()
        val purchaseAmount = PurchaseAmount(userInputData)


    }
}