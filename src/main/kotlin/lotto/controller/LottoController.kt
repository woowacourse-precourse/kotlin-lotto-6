package lotto.controller

import lotto.view.OutputView

class LottoController(
    private val outputView: OutputView
) {
    fun run() {
        outputView.printInputPriceMessage()
    }
}