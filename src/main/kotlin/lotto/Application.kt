package lotto

fun main() {
    val output = OutputView()

    val player = Player()
    output.printReceivePurchaseAmountInput()

    var amount: Int
    while (true) {
        try {
            amount = player.inputPurchaseAmount()
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)

        }
    }

    val count = player.calculateLottoGenerateCount(amount)
    output.printLottoGenerateCount(count)

    val lottoGenerator = LottoGenerator(count)
    val lottoTickets = lottoGenerator.generateLottoTickets()
    output.printLottoTickets(lottoTickets)

    val lottoMachine = LottoMachine()
    output.printReceiveWinningNumbersInput()
    var winningNumbers: List<Int>
    while (true) {
        try {
            winningNumbers = lottoMachine.inputWinningNumbers()
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)

        }
    }
    output.printReceiveBonusNumberInput()

    var bonusNumber: Int
    while (true) {
        try {
            bonusNumber = lottoMachine.inputBonusNumber(winningNumbers)
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)

        }
    }

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




