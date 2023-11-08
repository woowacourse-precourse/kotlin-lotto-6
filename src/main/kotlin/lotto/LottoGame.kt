package lotto

class LottoGame {

    private val outputView = OutputView()
    private val inputView = InputView()

    private lateinit var winningNumbers: List<Int>
    private lateinit var amount: String
    private var bonusNumber: Int = 0

    fun start() {
        amount = promptForPurchaseAmount()
        val lottoMachine = LottoMachine(amount)
        val quantity = lottoMachine.calculateLottoQuantity()
        outputView.printLottoQuantity(quantity)
        val list = lottoMachine.printNumbers(quantity)

        winningNumbers = promptForWinningNumbers()
        bonusNumber = promptForBonusNumber(winningNumbers)

        outputView.printWinningStatistics()
        val results = lottoMachine.calculateMatchResults(list, winningNumbers, bonusNumber)
        val stats = lottoMachine.tallyResults(results)
        val winningDetails = lottoMachine.getWinningDetails(stats)

        winningDetails.forEach { outputView.printWinningResults(it) }

        val profit = Profit().getProfit(stats, amount)
        outputView.printProfit(profit)
    }

    private fun promptForPurchaseAmount(): String {
        while (true) {
            try {
                outputView.printRequestInputPurchaseAmount()
                return inputView.inputPurchaseAmount()
            } catch (e: IllegalArgumentException) {
                println("\n${e.message}\n")
            }
        }
    }

    private fun promptForWinningNumbers(): List<Int> {
        while (true) {
            try {
                outputView.printRequestInputWinningNumber()
                val winningNumber = inputView.inputWinningNumber()
                return winningNumber.split(",").map { it.trim().toInt() }
            } catch (e: IllegalArgumentException) {
                println("\n${e.message}")
            }
        }
    }

    private fun promptForBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                outputView.printRequestInputBonusNumber()
                return inputView.inputBonusNumber(winningNumbers).toInt()
            } catch (e: IllegalArgumentException) {
                println("\n${e.message}")
            }
        }
    }

}