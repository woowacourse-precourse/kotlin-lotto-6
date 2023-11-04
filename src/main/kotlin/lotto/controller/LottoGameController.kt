package lotto.controller

import lotto.domain.LottoGame
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoGame: LottoGame,
) {

    fun run() {
        outputView.printAmountMessage()
        val purchaseAmount = inputView.inputPurchaseAmount()

    }
}