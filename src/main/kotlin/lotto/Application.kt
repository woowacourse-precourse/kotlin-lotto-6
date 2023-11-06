package lotto

fun main() {
    val player = Player()
    val amount = player.inputPurchaseAmount()
    val count = player.calculateLottoGenerateCount(amount)

    val lottoGenerator = LottoGenerator(count)
    lottoGenerator.printRandomLotto()

    val lottoMachine = LottoMachine()
    val winningNumbers = lottoMachine.inputWinningNumbers()
    lottoMachine.inputBonusNumber(winningNumbers)
}




