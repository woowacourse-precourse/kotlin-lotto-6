package lotto.controller

import LOTTO_PRICE
import LottoPurchaseView.inputPurchaseAmountOfLotto
import LottoPurchaseView.printPurchaseAmountOfLotto
import lotto.model.LottoModel
import lotto.model.LottoTicket
import lotto.presentation.LottoGeneratorView.printLottoTickets
import lotto.presentation.LottoGeneratorView.printPurchaseLottoCount

class LottoController() {
    private val lottoModel = LottoModel()
    val lottoTickets = mutableListOf<LottoTicket>()
    fun start() {
        try {
            printPurchaseAmountOfLotto()
            val purchaseAmount = inputPurchaseAmountOfLotto()

            printPurchaseLottoCount(purchaseAmount)

            generateLottoTickets(purchaseAmount / LOTTO_PRICE)

        } catch (e: IllegalArgumentException) {
            println(e.message)
            start()
        }
    }

    fun validateInputNumeric(input: String) {
        lottoModel.isPurchaseAmountNumeric(input)
    }

    fun validateInputPositive(input: Int) {
        lottoModel.isPurchaseAmountPositive(input)
    }

    fun validateInputDivisionPrice(input: Int) {
        lottoModel.isDivisibleBy1000(input)
    }

    fun generateLottoTickets(amount: Int) {
        repeat(amount) {
            val lottoTicket = LottoTicket()
            lottoTickets.add(lottoTicket)
        }
        printLottoTickets(lottoTickets)
    }
}