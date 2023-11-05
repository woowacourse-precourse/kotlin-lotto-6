package controller

import model.Money
import view.InputView
import view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {

    private lateinit var money: Money
    fun run() {
        do {
            outputView.printPurchaseAmount()
            val inputPrice = inputView.getValue()
            try {
                money = Money(inputPrice)
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
                continue
            }
            break
        } while (true)

        outputView.printPurchasedItemCount(money.getPurchasableLottoTicketCount())
    }
}
