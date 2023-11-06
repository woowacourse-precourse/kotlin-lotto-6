package lotto

class LottoMachine(private val amount: String) {

    fun calculateLottoQuantity(): Int {
        return amount.toInt() / PRICE_LOTTO
    }

    companion object {
        const val PRICE_LOTTO = 1000
    }
}