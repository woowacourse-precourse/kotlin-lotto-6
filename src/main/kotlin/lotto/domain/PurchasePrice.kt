package lotto.domain

class PurchasePrice(private val price: Int) {
    fun calculateLottoCount() = price / 1000
    fun getPurchasePrice() = price
}