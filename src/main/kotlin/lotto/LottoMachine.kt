package lotto

class LottoMachine(private val amount: String) {

    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()
    private var allLotto = mutableListOf<List<Int>>()

    fun calculateLottoQuantity(): Int {
        return amount.toInt() / PRICE_LOTTO
    }

    fun printNumbers(quantity: Int): List<List<Int>> {
        repeat(quantity) {
            val numbers = lottoGenerator.generateLotto()
            allLotto.add(numbers)
            outputView.printLottoNumbers(numbers)
        }
        return allLotto
    }

    companion object {
        const val PRICE_LOTTO = 1000
    }
}