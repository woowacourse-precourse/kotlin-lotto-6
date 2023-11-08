package lotto

class LottoGame {

    fun play() {
        val input = Input()
        val lottoManager = LottoManager()
        val compareLotto = CompareLotto()

        val price = getPrice(input)
        lottoManager.createLottoes(price)
        lottoManager.printLottoes(price)

        val lottoNumbers = getLottoNumber(input)
        val bonusNumber = getBonusNumber(input, lottoNumbers)

        val lottoResult = compareLotto.compareLotto(lottoManager.lottoes, lottoNumbers, bonusNumber)
        val rateOfReturnResult = compareLotto.calculateRateOfReturn(lottoResult, price)
        compareLotto.printResult(lottoResult)
        compareLotto.printRateOfReturnResult(rateOfReturnResult)
    }

    private fun getPrice(input: Input): Int {
        var price: Int
        while (true) {
            try {
                price = input.inputPurchasePrice()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return price
    }

    private fun getLottoNumber(input: Input): List<Int> {
        var lotto: List<Int>
        while (true) {
            try {
                lotto = input.inputLottoNumber()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return lotto
    }

    private fun getBonusNumber(input: Input, lottoNumbers: List<Int>): Int {
        var bonus: Int
        while (true) {
            try {
                bonus = input.inputLottoBonusNumber(lottoNumbers)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return bonus
    }
}