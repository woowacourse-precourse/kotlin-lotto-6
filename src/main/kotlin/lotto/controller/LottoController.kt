package lotto.controller

import lotto.exception.IllegalPurchaseAmountException
import lotto.model.Purchase
import lotto.view.InputView

class LottoController() {

    fun make() {
        val purchase = Purchase(getPurchaseAmount())
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
