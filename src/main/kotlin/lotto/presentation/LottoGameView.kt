package lotto.presentation

import lotto.Lotto

class LottoGameView {
    fun requestPurchaseMoney() {
        println(LOTTO_PURCHASE_REQUEST_MESSAGE)
    }

    fun printPurchasedLottos(lottoTickets: List<Lotto>) {
        println("\n${lottoTickets.size}$LOTTO_PURCHASE_RESPONSE_MESSAGE")
        lottoTickets.forEach { lotto ->
            println(lotto.getNumbers().sorted().joinToString(", ", "[", "]"))
        }
    }

    fun printErrorMessage(message: String?) {
        println("[ERROR]: ${message ?: "Unknown message"}")
    }
}