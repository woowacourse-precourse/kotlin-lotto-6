package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        purchaseLotto()
    }

    private fun purchaseLotto() {
        outputView.printInputMoney()
        inputView.readInputMoney()
    }
}