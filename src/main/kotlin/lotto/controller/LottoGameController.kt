package lotto.controller

import lotto.domain.LottoPurchaseAmountParser
import lotto.view.input.InputView
import lotto.view.output.OutputView

object LottoGameController {
    private val inputView = InputView
    private val outputView = OutputView
    private var lottoPurchaseNumber: Int = 0
    fun start() {
        purchaseLotto()


    }
    private fun purchaseLotto(){
        outputView.requestPurchaseAmountMessage()
        lottoPurchaseNumber= inputView.readPurchaseAmount()
        outputView.countLottoMessage(lottoPurchaseNumber)
    }
}
