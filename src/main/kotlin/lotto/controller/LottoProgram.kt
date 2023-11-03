package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

private const val LOTTO_PURCHASE_COST = 1000

class LottoProgram {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var purchaseAmount: Int = 0
    fun run() {
        outputView.printPurchaseAmount()
        purchaseAmount = inputView.getPurchaseAmount().toInt()
        print(getLottoTicketCount(purchaseAmount))
    }
    private fun getLottoTicketCount(purchaseAmount:Int) = purchaseAmount/ LOTTO_PURCHASE_COST

}