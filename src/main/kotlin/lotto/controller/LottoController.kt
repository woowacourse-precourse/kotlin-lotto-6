package lotto.controller

import LOTTO_PRICE
import LottoPurchaseView.inputMoneyToBuy
import LottoPurchaseView.printMoneyToBuy
import lotto.model.*
import lotto.presentation.LottoBonusView.inputBonusNumberOfLotto
import lotto.presentation.LottoBonusView.printBonusNumberOfLotto
import lotto.presentation.LottoGeneratorView.printLottoTickets
import lotto.presentation.LottoGeneratorView.printBuyLottoTickes
import lotto.presentation.LottoProfitView
import lotto.presentation.LottoStatisticsView.printStatistics
import lotto.presentation.LottoWinningView.inputWinningNumberOfLotto
import lotto.presentation.LottoWinningView.printWinningNumberOfLotto

class LottoController() {
    private val lottoMoney = LottoMoney()
    private val winningNumber = WinningNumber()
    private val bonusNumber = BonusNumber()
    val lottoTickets = mutableListOf<LottoTicket>()
    fun start() {
        try {
            printMoneyToBuy()
            val moneyToBuy = inputMoneyToBuy()

            printBuyLottoTickes(moneyToBuy)
            generateLottoTickets(moneyToBuy / LOTTO_PRICE)

            startWinningNumber(moneyToBuy)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            start()
        }
    }

    fun startWinningNumber(amount: Int) {
        try {
            printWinningNumberOfLotto()
            val winningNumber = inputWinningNumberOfLotto()

            startBonusNumber(winningNumber, amount)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            startWinningNumber(amount)
        }
    }

    fun startBonusNumber(winningNumber: List<Int>, amount: Int) {
        try {
            printBonusNumberOfLotto()
            val bonusNumber = inputBonusNumberOfLotto(winningNumber)

            val lottoMatch = LottoMatch(lottoTickets, winningNumber, bonusNumber)
            val lottoRank = lottoMatch.countMatch()

            printStatistics(lottoRank)
            startLottoProfit(lottoRank, amount)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            startBonusNumber(winningNumber, amount)
        }
    }

    fun startLottoProfit(rank: List<Int>, amount: Int) {
        val total = LottoProfit().calculateTotal(rank)
        val profit = LottoProfit().calculateProfit(total, amount)

        LottoProfitView.printLottoProfit(profit)
    }

    fun generateLottoTickets(amount: Int) {
        repeat(amount) {
            val lottoTicket = LottoTicket()
            lottoTickets.add(lottoTicket)
        }
        printLottoTickets(lottoTickets)
    }

    fun validateMoneyToBuyNumeric(input: String) {
        lottoMoney.isMoneyToBuyNumeric(input)
    }

    fun validateMoneyToBuyPositive(input: Int) {
        lottoMoney.isMoneyToBuyPositive(input)
    }

    fun validateMoneyToBuyDivisibleByLottoPrice(input: Int) {
        lottoMoney.isMoneyToBuyDivisibleBy1000(input)
    }

    fun validateWinningNumberSize(input: List<String>) {
        winningNumber.isWinningNumberSize(input)
    }

    fun validateWinningNumberNumeric(input: List<String>) {
        winningNumber.isWinningNumberNumeric(input)
    }

    fun validateWinningNumberRange(input: List<Int>) {
        winningNumber.isWinningNumberRange(input)
    }

    fun validateWinningNumberDuplicate(input: List<Int>) {
        winningNumber.isWinningNumberDuplicate(input)
    }

    fun validateBonusNumberNumeric(input: String) {
        bonusNumber.isBonusNumberNumeric(input)
    }

    fun validateBonusNumberRange(input: Int) {
        bonusNumber.isBonusNumberRange(input)
    }

    fun validateBonusNumberDuplication(input: Int, winningNumber: List<Int>) {
        bonusNumber.isBonusNumberDuplicate(input, winningNumber)
    }
}