package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        kotlin.runCatching {
            receiveAmount()
        }.onFailure {

        }
    }

    private fun receiveAmount() {
        outputView.outputAmount()
    }


}