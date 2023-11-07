package lotto.controller

import LOTTO_PRICE
import LottoPurchaseView.inputPurchaseAmountOfLotto
import LottoPurchaseView.printPurchaseAmountOfLotto
import lotto.model.LottoModel
import lotto.model.LottoTicket
import lotto.model.WinningNumber
import lotto.presentation.LottoGeneratorView.printLottoTickets
import lotto.presentation.LottoGeneratorView.printPurchaseLottoCount
import lotto.presentation.LottoWinningView.inputWinningNumberOfLotto
import lotto.presentation.LottoWinningView.printWinningNumberOfLotto

class LottoController() {
    private val lottoModel = LottoModel()
    private val winningNumber = WinningNumber()
    val lottoTickets = mutableListOf<LottoTicket>()
    fun start() {
        try {
            printPurchaseAmountOfLotto()
            val purchaseAmount = inputPurchaseAmountOfLotto()

            printPurchaseLottoCount(purchaseAmount)

            generateLottoTickets(purchaseAmount / LOTTO_PRICE)
            startWinningNumber()

        } catch (e: IllegalArgumentException) {
            println(e.message)
            start()
        }
    }

    fun startWinningNumber() {
        try {
            printWinningNumberOfLotto()
            val winningNumber = inputWinningNumberOfLotto()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            startWinningNumber()
        }
    }

    fun validateInputPurchaseAmountOfLottoNumeric(input: String) {
        lottoModel.isPurchaseAmountNumeric(input)
    }

    fun validateInputPurchaseAmountOfLottoPositive(input: Int) {
        lottoModel.isPurchaseAmountPositive(input)
    }

    fun validateInputPurchaseAmountOfLottoDivisionPrice(input: Int) {
        lottoModel.isDivisibleBy1000(input)
    }

    fun generateLottoTickets(amount: Int) {
        repeat(amount) {
            val lottoTicket = LottoTicket()
            lottoTickets.add(lottoTicket)
        }
        printLottoTickets(lottoTickets)
    }

    fun validateInputWinningNumberNumeric(input: List<String>) {
        winningNumber.isWinningNumberNumeric(input)
    }

    fun validateInputWinningNumberRange(input: List<Int>) {
        winningNumber.isWinningNumberRange(input)
    }
}