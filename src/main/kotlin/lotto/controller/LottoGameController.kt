package lotto.controller

import lotto.domain.lotto.Lotto
import lotto.domain.lotto.collection.LottoGame
import lotto.view.input.InputView
import lotto.view.output.OutputView

object LottoGameController {
    private val inputView = InputView
    private val outputView = OutputView
    private val lottoGame = LottoGame()
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
        lottoGame.generateLottos(lottoPurchaseCount)
        lottoGame.printLottos()
    }
}
