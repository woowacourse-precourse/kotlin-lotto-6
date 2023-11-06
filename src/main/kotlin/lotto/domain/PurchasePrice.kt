package lotto.domain

class PurchasePrice(private val price: Int) {
    fun calculateLottoCount() = price / LOTTO_PRICE
    fun getPurchasePrice() = price


    companion object {
        private const val LOTTO_PRICE = 1000
    }
}