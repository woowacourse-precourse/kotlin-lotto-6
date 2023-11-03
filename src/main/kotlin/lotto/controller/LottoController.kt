package lotto.controller

import lotto.model.LottoTicket
import lotto.util.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    private val lottoGenerator = LottoGenerator()
    private var purchaseCount = 0

    fun run() {
        settingPurchaseCount()

        val lottoTicket = LottoTicket(purchaseCount)
        println()
        outputView.printPurchaseCount(purchaseCount)
        repeat(purchaseCount) {
            val numbers = lottoGenerator.getSortedNumbers()
            lottoTicket.addNumbers(numbers)
        }
        outputView.printLottoTicket(lottoTicket)
    }

    private fun settingPurchaseCount() {
        outputView.printGameStartMessage()
        purchaseCount = getPurchaseCount()
    }

    private fun getPurchaseCount(): Int {
        val userInputPrice = inputView.getValidateUserInput()
        return userInputPrice / 1000
    }
}