package lotto.controller

import lotto.Lotto
import lotto.model.LottoNumber
import lotto.model.LottoStatus.LOTTO_AMOUNT
import lotto.model.LottoStatus.LOTTO_WIN_NUMBER
import lotto.model.LottoStatus.LOTTO_BONUS_NUMBER
import lotto.model.LottoStatus.LOTTO_CALCULATE
import lotto.model.LottoStatus.LOTTO_END
import lotto.model.LottoWinningRankCalculator
import lotto.model.ProfitCalculator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val lottoNumber: LottoNumber,
    private val lottoWinningRankCalculator: LottoWinningRankCalculator,
    private val profitCalculator: ProfitCalculator
) {
    private var lottoStatus = LOTTO_AMOUNT
    private var amount: Int = 0
    private lateinit var lotteryTickets: List<Lotto>
    private lateinit var winNumber: List<Int>
    private var bonusNumber: Int = 0

    fun run() {
        while (true) {
            when (lottoStatus) {
                LOTTO_AMOUNT ->
                    inputAmount()

                LOTTO_WIN_NUMBER ->
                    inputWinNumber()

                LOTTO_BONUS_NUMBER ->
                    inputBonusNumber()

                LOTTO_CALCULATE ->
                    calculateRank()

                LOTTO_END ->
                    break
            }
        }
    }

    private fun inputAmount() {
        try {
            outputView.printInputPriceMessage()
            amount = inputView.inputPurchaseAmount()
            val lottoTicketCount = amount / 1000
            outputView.printPurchaseNumberMessage(lottoTicketCount)
            lotteryTickets = lottoNumber.generateLotto(lottoTicketCount)
            lottoStatus = LOTTO_WIN_NUMBER
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }

    private fun inputWinNumber() {
        try {
            outputView.printInputWinNumberMessage()
            winNumber = inputView.inputWinNumber()
            lottoStatus = LOTTO_BONUS_NUMBER
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }

    private fun inputBonusNumber() {
        try {
            outputView.printInputBonusNumberMessage()
            bonusNumber = inputView.inputBonusNumber(winNumber)
            lottoStatus = LOTTO_CALCULATE
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }

    private fun calculateRank() {
        outputView.printWinStaticsMessage()
        val wonLotto = lottoWinningRankCalculator.calculateRank(lotteryTickets, winNumber, bonusNumber)
        outputView.printWinStats(wonLotto)
        val profitRate = profitCalculator.calculateProfitRate(amount, lottoWinningRankCalculator.prize)
        outputView.printProfitRate(profitRate)
        lottoStatus = LOTTO_END
    }
}