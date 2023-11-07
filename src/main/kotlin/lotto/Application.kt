package lotto

fun main() {
    val player = Player()
    val amount = player.inputPurchaseAmount()
    val count = player.calculateLottoGenerateCount(amount)

    val lottoGenerator = LottoGenerator(count)
    val lottoTickets = lottoGenerator.generateLottoTickets()

    val lottoMachine = LottoMachine()
    val winningNumbers = lottoMachine.inputWinningNumbers()
    val bonusNumber = lottoMachine.inputBonusNumber(winningNumbers)

    val winningResult = WinningResult(lottoTickets, winningNumbers, bonusNumber)
    winningResult.printResults()
}




