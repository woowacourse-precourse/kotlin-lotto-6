package lotto.controller

import LOTTO_PRICE
import LottoPurchaseView.inputPurchaseAmountOfLotto
import LottoPurchaseView.printPurchaseAmountOfLotto
import lotto.model.BonusNumber
import lotto.model.LottoModel
import lotto.model.LottoTicket
import lotto.model.WinningNumber
import lotto.presentation.LottoBonusView.inputBonusNumberOfLotto
import lotto.presentation.LottoBonusView.printBonusNumberOfLotto
import lotto.presentation.LottoGeneratorView.printLottoTickets
import lotto.presentation.LottoGeneratorView.printPurchaseLottoCount
import lotto.presentation.LottoWinningView.inputWinningNumberOfLotto
import lotto.presentation.LottoWinningView.printWinningNumberOfLotto

class LottoController() {
    private val lottoModel = LottoModel()
    private val winningNumber = WinningNumber()
    private val bonusNumber = BonusNumber()
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

            startBonusNumber()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            startWinningNumber()
        }
    }

    fun startBonusNumber() {
        try {
            printBonusNumberOfLotto()
            val bonusNumber = inputBonusNumberOfLotto()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            startBonusNumber()
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

    fun validateInputWinningNumberSize(input: List<String>) {
        winningNumber.isWinningNumberSize(input)
    }

    fun validateInputWinningNumberNumeric(input: List<String>) {
        winningNumber.isWinningNumberNumeric(input)
    }

    fun validateInputWinningNumberRange(input: List<Int>) {
        winningNumber.isWinningNumberRange(input)
    }

    fun validateInputWinningNumberDuplicate(input: List<Int>) {
        winningNumber.isWinningNumberDuplicate(input)
    }

    fun validateInputBonusNumberNumeric(input: String) {
        bonusNumber.isBonusNumberNumeric(input)
    }

    fun validateInputBonusNumberRange(input: Int) {
        bonusNumber.isBonusNumberRange(input)
    }
}