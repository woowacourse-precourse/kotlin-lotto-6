package lotto.view

import lotto.utils.ConsoleMessage
import lotto.utils.ErrorMessage

class LottoView {
    fun requestPurchaseMoneyValueMessage() {
        println(ConsoleMessage.REQUEST_PURCHASE_MONEY_VALUE)
    }
    fun displayInappropriateValueError() {
        println("${ErrorMessage.ERRORMESSAGE_TITLE} ${ErrorMessage.INAPPROPRIATE_VALUE}")
    }
}