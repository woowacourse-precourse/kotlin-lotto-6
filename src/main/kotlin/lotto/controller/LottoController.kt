package lotto.controller

import lotto.model.LottoNumber
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val lottoNumber: LottoNumber
) {
    fun run() {
        outputView.printInputPriceMessage()
        val number = inputView.inputPurchaseAmount()
        outputView.printPurchaseNumber(number)
        val lotteryTickets = lottoNumber.generateLotto(number)
    }

}