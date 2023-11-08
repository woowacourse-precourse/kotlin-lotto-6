package lotto.controller

import lotto.domain.*
import lotto.view.OutputView

class LottoGame(private val output: OutputView, private val player: Player, private val lottoMachine: LottoMachine) {
    fun start() {
        val amount = getPurchaseAmount()
        val lottoTickets = getLottoTickets(amount)
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        showWinningResult(lottoTickets, winningNumbers, bonusNumber)
    }

    private fun getPurchaseAmount(): Int {
        var amount: Int
        output.printReceivePurchaseAmountInput()

        while (true) {
            try {
                amount = player.inputPurchaseAmount()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)

            }
        }
        return amount
    }

    private fun getLottoTickets(amount: Int): List<Lotto> {
        val count = player.calculateLottoGenerateCount(amount)
        output.printLottoGenerateCount(count)

        val lottoGenerator = LottoGenerator(count)
        val lottoTickets = lottoGenerator.generateLottoTickets()
        output.printLottoTickets(lottoTickets)

        return lottoTickets
    }


    private fun getWinningNumbers(): List<Int> {
        var winningNumbers: List<Int>
        output.printReceiveWinningNumbersInput()
        while (true) {
            try {
                winningNumbers = lottoMachine.inputWinningNumbers()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)

            }
        }
        return winningNumbers
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int {
        var bonusNumber: Int
        output.printReceiveBonusNumberInput()

        while (true) {
            try {
                bonusNumber = lottoMachine.inputBonusNumber(winningNumbers)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)

            }
        }
        return bonusNumber
    }


    private fun showWinningResult(lottoTickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int) {
        val winningResult = WinningResult(lottoTickets, winningNumbers, bonusNumber)

        output.printWinningStatistics()
        val statisticsResults = winningResult.returnStatisticsResults()
        statisticsResults.forEach { (rankDescription, formattedPrizeMoney, count) ->
            output.printWinningStatisticsResult(rankDescription, formattedPrizeMoney, count)
        }

        val statistics = winningResult.calculateStatistics()
        val profitRate = winningResult.returnProfitRateResults(statistics)
        output.printProfitRateResult(profitRate)

    }

}