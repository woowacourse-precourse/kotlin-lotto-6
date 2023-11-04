package lotto.Controller

import lotto.Lotto
import lotto.utils.Constants
import lotto.view.InputView
import lotto.view.OutputView

class LottoManager(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        outputView.showInputBuyPriceMessage()
        val buyPrice = inputView.inputBuyPrice()
        val ticket = calculateTicket(buyPrice)
        outputView.showBuyTicketMessage(ticket)
        outputView.showInputMyNumbersMessage()

        val numbers = inputView.inputMyNumbers()
        val lotto = Lotto(splitMyNumbers(numbers))
    }

    private fun calculateTicket(buyPrice: Int): Int {
        return buyPrice / Constants.THOUSAND_PRICE
    }

    private fun splitMyNumbers(myNumbers: String): List<Int> {
        return myNumbers.split(Constants.DELIMITER).map { it.toInt() }
    }
}