package lotto.controller

import lotto.util.Printer
import lotto.util.Reader
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView(Reader())
    private val outputView = OutputView(Printer())

    fun run() {
        purchaseLotto()
    }

    private fun purchaseLotto() {
        outputView.printInputMoney()
        inputView.readInputMoney()
    }
}