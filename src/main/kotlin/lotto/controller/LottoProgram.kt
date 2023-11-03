package lotto.controller

import lotto.util.Validator.isItInteger
import lotto.view.InputView
import lotto.view.OutputView

private const val LOTTO_PURCHASE_COST = 1000

class LottoProgram {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        outputView.printPurchaseAmount()
       val purchaseAmount = inputView.getPurchaseAmount()
        isItInteger(purchaseAmount)
    }
    private fun getLottoTicketCount(purchaseAmount:Int) = purchaseAmount/ LOTTO_PURCHASE_COST

}