package lotto.Controller

import lotto.Lotto
import lotto.utils.Constants
import lotto.validate.ValidateSplit
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

    fun calculateTicket(buyPrice: Int): Int {
        return buyPrice / Constants.THOUSAND_PRICE
    }

    fun splitMyNumbers(myNumbers: String): List<Int> {
        val validateSplit = ValidateSplit()
        validateSplit.validateSplitMyNumbers(myNumbers.split(Constants.DELIMITER))

    }
}