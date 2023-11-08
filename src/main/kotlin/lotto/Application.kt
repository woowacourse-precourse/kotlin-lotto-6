package lotto

fun main() {
    LottoUI().printBuyPrice()
    val buyPrice = LottoUI().inputBuyPrice()
    LottoUI().printBuyLottoCount(buyPrice)
    val buyCount = buyPrice.toInt() / 1000
    val lottos = LottoService().buyLotto(buyCount)
    LottoUI().printLottoNumbers(lottos)
    LottoUI().printWinningNumbers()
    val winningLotto = LottoUI().inputWinningNumbers()
    LottoUI().printBonusNumber()
    val bonusNumber = LottoUI().inputBonusNumber(winningLotto)
    LottoUI().printResult(lottos, winningLotto, bonusNumber)
}
