package lotto.domain

import lotto.utils.Constants
import lotto.view.OutputView.showInputBuyPriceMessage
import lotto.view.InputView.inputBuyPrice

class Purchase {
    init {
        showInputBuyPriceMessage()
    }
    fun buyLotto(): Int {
        val money = inputBuyPrice()
        return money
    }

    fun calculateTicket(buyPrice: Int): Int {
        return buyPrice / Constants.THOUSAND_PRICE
    }

}