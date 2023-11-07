package lotto.controller

import lotto.domain.LottoPurchaseAmountParser
import lotto.view.input.InputView
import lotto.view.output.OutputView


object LottoGameController {
    private val inputView = InputView
    private val outputView = OutputView
    fun start() {
        outputView.requestPurchaseAmountMessage()
        val lottoPurchaseNumber= inputView.readPurchaseAmount()



    }
}
