package lotto.domain

import lotto.utils.Constants
import lotto.view.OutputView.showInputBuyPriceMessage
import lotto.view.InputView.inputBuyPrice

class LottoPurchase {

    fun buyLotto(): Int {
        return inputBuyPrice()
    }

    fun calculateTicket(buyPrice: Int): Int {
        return buyPrice / Constants.THOUSAND_PRICE
    }
}