package lotto.controller

import lotto.model.LottoTicketCount
import lotto.view.InputView
import lotto.view.OutputView

class LottoProgram {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        outputView.printPurchaseAmount()

        val userInput = inputView.getValidPurchaseAmount()
        val lottoTicketCount = LottoTicketCount(userInput)
        val lottoCount = lottoTicketCount.lottoCount

        outputView.printLottoCount(lottoCount)

    }

    companion object {
        const val LOTTO_PURCHASE_COST = 1000
    }
}