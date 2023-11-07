package lotto

class LottoMachine(private val amount: String) {

    private val lottoGenerator = LottoGenerator()

    fun calculateLottoQuantity(): Int {
        return amount.toInt() / PRICE_LOTTO
    }

    fun printNumbers(quantity: Int) {
        repeat(quantity) { println(lottoGenerator.generateLotto()) }
    }

    companion object {
        const val PRICE_LOTTO = 1000
    }
}