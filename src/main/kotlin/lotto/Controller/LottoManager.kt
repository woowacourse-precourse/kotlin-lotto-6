package lotto.Controller

import lotto.Lotto
import lotto.utils.Constants
import lotto.view.InputView
import lotto.view.OutputView

class LottoManager(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        outputView.showInputBuyPriceMessage()
        val ticket = calculateTicket(inputView.InputBuyPriceMessage())
        outputView.showBuyTicketMessage(ticket)
        outputView.showInputMyNumbersMessage()
        val numbers = inputView.InputMyNumbersMessage()

        val lotto = Lotto(splitMyNumbers(numbers))
    }

    fun calculateTicket(buyPrice: Int): Int {
        return buyPrice / Constants.THOUSAND_PRICE
    }

    fun splitMyNumbers(myNumbers: String): List<Int> {
        return myNumbers.split(Constants.DELIMITER).map { it.toInt() }
    }

}