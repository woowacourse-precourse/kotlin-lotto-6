package lotto.controller

import lotto.domain.model.Purchase
import lotto.exception.IllegalPurchaseAmountException
import lotto.view.InputView
import lotto.view.OutputView

class LottoController() {

    fun make() {
        val purchase = Purchase(getPurchaseAmount())
        OutputView.printLottos(purchase)
    }

    private fun getPurchaseAmount(): Int {
        try {
            return InputView.inputPurchaseAmount()
        } catch (e: IllegalArgumentException) {
            throw IllegalPurchaseAmountException()
        }
    }

    private fun setWinningNumber() {
        val winningNumber = inputView.inputWinningNumber()
    }

    private fun setBonusNumber() {
        val bonusNumber = inputView.inputBonusNumber()
    }
}
