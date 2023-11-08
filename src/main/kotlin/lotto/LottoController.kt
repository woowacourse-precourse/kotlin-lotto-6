package lotto

import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputview: InputView = InputView(),
                      private val outputview: OutputView = OutputView()) {
    init {
        val amount: Int = getAmount()
    }
    private fun getAmount(): Int {
        var amount: Int
        while(true) {
            try{
                outputview.amountMessage()
                amount = inputview.inputAmount()
                return amount
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }
}