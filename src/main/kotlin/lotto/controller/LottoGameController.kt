package lotto.controller

import lotto.constants.GameConstants.LOTTO_COUNT
import lotto.constants.GameConstants.PURCHASE_UNIT
import lotto.domain.lotto.model.Lotties
import lotto.domain.winning.model.WinningRank
import lotto.view.input.InputView
import lotto.view.output.OutputView

object LottoGameController {
    private val inputView = InputView
    private val outputView = OutputView
    private val lotties = Lotties()
    private var lottoPurchaseCount: Int = 0
    private var lottoPurchaseAmount: Int = 0
    private var winningNumbers = List(LOTTO_COUNT) { 0 }
    private var bonusNumber: Int = 0
    private var rankCounts: Map<WinningRank, Int> = mapOf()
    private var profitRate: Double = 0.0
    private var profitAmount: Long = 0

    fun start() {
        purchaseLotto()
    }

    private fun purchaseLotto() {
        outputView.requestPurchaseAmountMessage()
        lottoPurchaseAmount = inputView.readPurchaseAmount()
        lottoPurchaseCount = lottoPurchaseAmount / PURCHASE_UNIT
        outputView.countLottoMessage(lottoPurchaseCount)
        setLotto(lottoPurchaseCount)
    }

    private fun setLotto(lottoPurchaseCount: Int) {
        lotties.generateLotties(lottoPurchaseCount)
        lotties.printLotties()
        readWinningNumbersAndBonusNumber()
    }

    private fun readWinningNumbersAndBonusNumber() {
        outputView.requestWinningNumbersMessage()
        winningNumbers = InputView.readWinningNumber()
        outputView.requestBonusNumberMessage()
        bonusNumber = InputView.readBonusNumber(winningNumbers)
        calculateWinningResults()
    }

    private fun calculateWinningResults() {
        rankCounts = lotties.winningResults(winningNumbers, bonusNumber)

        outputView.winningStatisticsMessage()
        WinningRank.entries.forEach { rank ->
            if (rank != WinningRank.NONE) {
                outputView.printRankStatistics(rank, rankCounts[rank] ?: 0)
            }
        }
        profitRateResult()
    }

    private fun profitRateResult() {
        profitAmount = lotties.calculateProfitAmount(rankCounts)
        profitRate = lotties.calculateProfitRate(profitAmount, lottoPurchaseAmount)
        outputView.profitRateMessage(profitRate)
    }
}
