package lotto.controller

import lotto.domain.lotto.collection.Lotties
import lotto.view.input.InputView
import lotto.view.output.OutputView

object LottoGameController {
    private val inputView = InputView
    private val outputView = OutputView
    private val lottoGame = Lotties()
    private var lottoPurchaseCount: Int = 0
    fun start() {
        purchaseLotto()
        setLotto()
    }

    private fun purchaseLotto(){
        outputView.requestPurchaseAmountMessage()
        lottoPurchaseCount= inputView.readPurchaseAmount()
        outputView.countLottoMessage(lottoPurchaseCount)
    }
    private fun setLotto(){
        lottoGame.generateLotties(lottoPurchaseCount)
        lottoGame.printLotties()
    }
}
