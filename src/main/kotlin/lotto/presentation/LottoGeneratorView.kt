package lotto.presentation

import LOTTO_PRICE
import PURCHASE_LOTTO_COUNT_MESSAGE
import lotto.model.LottoTicket

object LottoGeneratorView {
    fun printBuyLottoTickes(amount: Int) {
        println(PURCHASE_LOTTO_COUNT_MESSAGE.format(amount / LOTTO_PRICE))
    }

    fun printLottoTickets(tickets: MutableList<LottoTicket>) {
        tickets.forEach { lotto -> println(lotto.ticket) }
        println()
    }
}