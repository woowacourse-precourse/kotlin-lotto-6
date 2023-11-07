package lotto

fun main() {
    val player = Player()
    val amount = player.inputPurchaseAmount()
    val count = player.calculateLottoGenerateCount(amount)

    val lottoGenerator = LottoGenerator(count)
    lottoGenerator.generateLottoTickets()

    val lottoMachine = LottoMachine()
    val winningNumbers = lottoMachine.inputWinningNumbers()
    lottoMachine.inputBonusNumber(winningNumbers)
}




