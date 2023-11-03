package lotto.controller

import lotto.util.Validator.isItInteger
import lotto.util.Validator.isItPositive
import lotto.view.InputView
import lotto.view.OutputView

class LottoProgram {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        outputView.printPurchaseAmount()
       val purchaseAmount = inputView.getPurchaseAmount()
        isItPositive(purchaseAmount.toInt())
    }
    private fun getLottoTicketCount(purchaseAmount:Int) = purchaseAmount/ LOTTO_PURCHASE_COST

    companion object{
        const val LOTTO_PURCHASE_COST = 1000
    }
}