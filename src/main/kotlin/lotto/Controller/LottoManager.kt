package lotto.Controller

import lotto.utils.Constants
import lotto.view.InputView
import lotto.view.OutputView

class LottoManager(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        outputView.showInputBuyPriceMessage()

    }

}