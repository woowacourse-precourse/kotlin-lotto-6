package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.Lotto.Companion.LOTTO_PRICE_PER_GAME
import lotto.MoneyUtils
import lotto.presentation.LottoGameView

class LottoGameController {
    private val lottoGameView = LottoGameView()
    private var lottoTickets = emptyList<Lotto>()

    fun start() {
        val purchaseMoney = requestPurchaseMoney()
        purchaseLottoTickets(purchaseMoney)
        lottoGameView.printPurchasedLottos(lottoTickets)
    }

    private fun purchaseLottoTickets(purchaseMoney: Int) {
        val ticketAmount = purchaseMoney / LOTTO_PRICE_PER_GAME
        lottoTickets = (1..ticketAmount).map { createRandomLottoTicket() }
    }

    private fun createRandomLottoTicket(): Lotto {
        return Lotto.generateRandomLottoNumbers()
    }

    private fun requestPurchaseMoney(): Int {
        lottoGameView.requestPurchaseMoney()
        return getInputMoney()
    }

    private fun getInputMoney(): Int {
        var inputMoney = ""
        var isValid = false
        while (!isValid) {
            try {
                inputMoney = Console.readLine()
                MoneyUtils.validateInputMoney(inputMoney)
                isValid = true
            } catch (exception: IllegalArgumentException) {
                lottoGameView.printErrorMessage(exception.message)
            }
        }
        return inputMoney.toInt()
    }
}