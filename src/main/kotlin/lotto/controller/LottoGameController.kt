package lotto.controller

import lotto.domain.lotto.model.Lotties
import lotto.view.input.InputView
import lotto.view.output.OutputView

object LottoGameController {
    private val inputView = InputView
    private val outputView = OutputView
    private val lotties = Lotties()
    private var winningNumbers = List(6) { 0 }
    private var bonusNumber = 0

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
        readWinningNumbersAndBonusNumber()
    }

    private fun readWinningNumbersAndBonusNumber(): Pair<List<Int>, Int> {
        winningNumbers = InputView.readWinningNumber()
        outputView.requestBonusNumberMessage()
        bonusNumber = InputView.readBonusNumber()
        inputView.validateBonusNumberNotInWinningNumbers(bonusNumber=bonusNumber, winningNumbers=winningNumbers)

        return Pair(winningNumbers, bonusNumber)
    }
}
