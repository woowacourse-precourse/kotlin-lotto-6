package lotto.controller

import lotto.model.LottoTicket
import lotto.util.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    private val lottoGenerator = LottoGenerator()

    fun run() {
        outputView.printGameStartMessage()
        val userInputPrice = inputView.getValidateUserInput()
        val purchaseCount = userInputPrice / 1000
        val lottoTicket = LottoTicket(purchaseCount)
        println()
        outputView.printPurchaseCount(purchaseCount)
        repeat(purchaseCount)
        {
            val numbers = lottoGenerator.getSortedNumbers()
            lottoTicket.addNumbers(numbers)
        }
        outputView.printLottoTicket(lottoTicket)
    }
}