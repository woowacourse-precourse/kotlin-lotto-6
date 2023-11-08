package lotto

fun main() {
    LottoUI().printBuyPrice()
    val buyPrice = LottoUI().inputBuyPrice()
    LottoUI().printBuyLottoCount(buyPrice)
    val buyCount = buyPrice.toInt() / 1000
    val buyLottos = LottoService().buyLotto(buyCount)
}
