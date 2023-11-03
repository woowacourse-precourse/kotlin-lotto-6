package lotto.controller

import lotto.model.LottoTicketCount
import lotto.util.Validator.isValidPurchaseAmount
import lotto.view.InputView
import lotto.view.OutputView

class LottoProgram {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var lottoCount = 0

    fun run() {
        outputView.printPurchaseAmount()

        val userInput = inputView.getPurchaseAmount()
        isValidPurchaseAmount(userInput)
        val lottoTicketCount = LottoTicketCount(userInput)
        lottoCount = lottoTicketCount.lottoCount

    }

    companion object {
        const val LOTTO_PURCHASE_COST = 1000
    }
}