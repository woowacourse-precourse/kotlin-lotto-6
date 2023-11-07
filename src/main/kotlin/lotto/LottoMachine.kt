package lotto

class LottoMachine(private val amount: String) {

    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()

    fun calculateLottoQuantity(): Int {
        return amount.toInt() / PRICE_LOTTO
    }

    fun printNumbers(quantity: Int) {
        repeat(quantity) { outputView.printLottoNumbers(lottoGenerator.generateLotto()) }
    }

    companion object {
        const val PRICE_LOTTO = 1000
    }
}