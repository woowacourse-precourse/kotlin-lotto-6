package lotto.view

import lotto.Lotto
import lotto.utils.Messages

object OutputView {
    fun showInputBuyPriceMessage() {
        println(Messages.BUY_PRICE_MESSAGE)
    }
    fun showInputMyNumbersMessage() {
        println(Messages.INPUT_MY_NUMBERS_MESSAGE)
    }

    fun showBuyTicketMessage(ticket: Int) {
        println("$ticket${Messages.BUY_TICKET_MESSAGE}")
    }

    fun showLottoNumbers(lottoNumbers: MutableList<Lotto>) {
        for (lottoNumber in lottoNumbers) {
            println(lottoNumber)
        }
    }

    fun showInputBonusNumberMessage() {
        println(Messages.BONUS_NUMBER_MESSAGE)
    }
}