package lotto.controller

import lotto.domain.lotto.model.Lotties
import lotto.view.input.InputView
import lotto.view.output.OutputView

object LottoGameController {
    private val inputView = InputView
    private val outputView = OutputView
    private val lotties = Lotties()

    fun start() {
        purchaseLotto()
        setUserWinningNumber()
    }

    private fun purchaseLotto(){
        outputView.requestPurchaseAmountMessage()
        val lottoPurchaseCount: Int = inputView.readPurchaseAmount()
        outputView.countLottoMessage(lottoPurchaseCount)
        setLotto(lottoPurchaseCount)
    }

    private fun setLotto(lottoPurchaseCount: Int){
        lotties.generateLotties(lottoPurchaseCount)
        lotties.printLotties()
    }

    private fun setUserWinningNumber(){
        outputView.requestWinningNumbersMessage()
        val winningNumber = inputView.readWinningNumber()
        outputView.requestBonusNumberMessage()
        val bonusNumber = inputView.readBonusNumber()
    }
}
