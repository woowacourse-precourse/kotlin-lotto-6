package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

class LottoController(inputView: InputView, outputView: OutputView) {

    private val inputView = InputView()

    fun make() {
        setPurchaseAmount()
        setWinningNumber()
        setBonusNumber()
    }

    private fun setPurchaseAmount() {
        val purchaseAmount = inputView.inputPurchaseAmount()
    }

    private fun setWinningNumber() {
        val winningNumber = inputView.inputWinningNumber()
    }

    private fun setBonusNumber() {
        val bonusNumber = inputView.inputBonusNumber()
    }
}
