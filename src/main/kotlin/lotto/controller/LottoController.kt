package lotto.controller

import lotto.domain.WinningLotto
import lotto.domain.model.Lotto
import lotto.domain.model.Purchase
import lotto.exception.IllegalBonusNumberException
import lotto.exception.IllegalPurchaseAmountException
import lotto.exception.IllegalWinningNumberException
import lotto.view.InputView
import lotto.view.OutputView

class LottoController() {

    fun make() {
        val purchase = Purchase(getPurchaseAmount())
        val winningLotto = WinningLotto(Lotto(getWinningNumber()), getBonusNumber())
        OutputView.printLottos(purchase)
    }

    private fun getPurchaseAmount(): Int {
        try {
            return InputView.inputPurchaseAmount()
        } catch (e: IllegalArgumentException) {
            throw IllegalPurchaseAmountException()
        }
    }

    private fun getWinningNumber(): List<Int> {
        try {
            return InputView.inputWinningNumber()
        } catch (e: IllegalArgumentException) {
            throw IllegalWinningNumberException()
        }
    }

    private fun getBonusNumber(): Int {
        try {
            return InputView.inputBonusNumber()
        } catch (e: IllegalArgumentException) {
            throw IllegalBonusNumberException()
        }
    }
}
