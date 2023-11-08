package lotto.controller

import lotto.constants.GameConstants.LOTTO_COUNT
import lotto.constants.GameConstants.PURCHASE_UNIT
import lotto.domain.lotto.model.Lotties
import lotto.domain.winningnumber.WinningRank
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

    fun start() {
        purchaseLotto()
        setLotto(lottoPurchaseCount)
        readWinningNumbersAndBonusNumber()
    }

    private fun purchaseLotto() {
        outputView.requestPurchaseAmountMessage()
        lottoPurchaseAmount = inputView.readPurchaseAmount()
        lottoPurchaseCount = lottoPurchaseAmount / PURCHASE_UNIT
        outputView.countLottoMessage(lottoPurchaseCount)
    }

    private fun setLotto(lottoPurchaseCount: Int) {
        lotties.generateLotties(lottoPurchaseCount)
        lotties.printLotties()
    }

    private fun readWinningNumbersAndBonusNumber() {
        outputView.requestWinningNumbersMessage()
        winningNumbers = InputView.readWinningNumber()
        outputView.requestBonusNumberMessage()
        bonusNumber = InputView.readBonusNumber(winningNumbers)
        calculateResults()
    }

    private fun calculateResults() {
        val rankCounts = lotties.winningResults(winningNumbers, bonusNumber)

        outputView.winningStatisticsMessage()
        WinningRank.entries.forEach { rank ->
            if (rank != WinningRank.NONE) {
                outputView.printRankStatistics(rank, rankCounts[rank] ?: 0)
            }
        }
    }
}
