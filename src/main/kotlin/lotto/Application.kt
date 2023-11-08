package lotto

fun main() {
    val purchaseAmount = LottoLogic.getLottoPurchaseAmount()
    println()

    val lottoCount = purchaseAmount / 1000
    val lotto = LottoLogic.createLotto(lottoCount)
    LottoLogic.printLotto(lotto)
    println()

    val winningNumbers = LottoLogic.getWinningNumbers()
    println()

    val bonusNumber = LottoLogic.getBonusNumber(winningNumbers)
    println()

    val results = LottoLogic.calculateLottoResults(lotto, winningNumbers, bonusNumber)
    LottoLogic.printLottoResultMessages(results)
    LottoLogic.printLottoReturnRate(purchaseAmount, results)
}
