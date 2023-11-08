package lotto

import lotto.domain.*

fun main() {
    val store = Store()
    val numberOfLotto = buyLotto(store)
    val winningNumberSet = setupWinningNumber()
    printLottoResult(numberOfLotto, winningNumberSet)
}

private fun buyLotto(store: Store): List<Lotto> {
    val totalSold = store.payToBuy()
    val generateLotto = LottoGenerate()
    val lottos = List(totalSold) { generateLotto.issueLotto() }
    lottos.forEach { it.printLottoNumber() }

    return lottos
}

private fun setupWinningNumber(): Pair<List<Int>, Int> {
    val winningNumber = WinningNumber()
    winningNumber.decideWinningNumbers()
    winningNumber.decideBonusNumber()
    val winningNumbers = winningNumber.getWinningNumbers()
    val bonusNumber = winningNumber.getBonusNumber()
    return Pair(winningNumbers, bonusNumber)
}

private fun printLottoResult(lottos: List<Lotto>, winningNumbersSet: Pair<List<Int>, Int>){
    val winningResult = LottoResult(lottos, winningNumbersSet)
    winningResult.printResultStatistics()
    winningResult.computeProfit(lottos.size * 1000)
    winningResult.printProfit()
}