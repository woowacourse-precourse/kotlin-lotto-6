package lotto

fun main() {
    val output = OutputView()

    val player = Player()
    output.printReceivePurchaseAmountInput()
    val amount = player.inputPurchaseAmount()
    val count = player.calculateLottoGenerateCount(amount)
    output.printLottoGenerateCount(count)

    val lottoGenerator = LottoGenerator(count)
    val lottoTickets = lottoGenerator.generateLottoTickets()
    output.printLottoTickets(lottoTickets)

    val lottoMachine = LottoMachine()
    output.printReceiveWinningNumbersInput()
    val winningNumbers = lottoMachine.inputWinningNumbers()
    output.printReceiveBonusNumberInput()
    val bonusNumber = lottoMachine.inputBonusNumber(winningNumbers)

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




