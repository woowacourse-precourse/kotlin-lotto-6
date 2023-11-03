package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

class LottoProgram {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var purchaseAmount: Int = 0
    fun run() {
        outputView.printPurchaseAmount()
        purchaseAmount = inputView.getPurchaseAmount().toInt()
        print(getLottoTicketCount(purchaseAmount))
    }
    private fun getLottoTicketCount(purchaseAmount:Int) = purchaseAmount/1000

}