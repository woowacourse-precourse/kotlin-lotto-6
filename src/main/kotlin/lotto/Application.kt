package lotto

fun main() {
    LottoUI().printBuyPrice()
    val buyPrice = LottoUI().inputBuyPrice()
    LottoUI().printBuyLottoCount(buyPrice)
}
