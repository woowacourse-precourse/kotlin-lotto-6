package lotto

class LottoStore {
    private val randomLottos = mutableListOf<List<Int>>()
    private val lottoGameView = LottoGameView()
    fun startSellLotto() {
        lottoGameView.startInputLottoMoney()
        val seller = LottoSeller().generateLottoNumbers(userInput(User().inputMoney()))
        showRandomLotto(seller)
        lottoGameView.inputUserLottoNumber()
        val lottoNumbers = LottoSeller().isValidateLotto()
        lottoGameView.inputBonusNumber()
        val lottoSeller = LottoSeller()
        val bonusNum: Int = try {
            lottoSeller.checkLottoHasBonusNum(lottoNumbers, User().inputBonusNum())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            lottoSeller.checkLottoHasBonusNum(lottoNumbers, User().inputBonusNum())
        }
        resultLotto(lottoNumbers, bonusNum)
    }

    private fun userInput(money: String): Int {
        return try {
            LottoSeller().checkLottoTicketCount(money)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            userInput(User().inputMoney())
        }
    }

    private fun showRandomLotto(randomLotto: List<LottoNumberGenerator>) {
        println("${randomLotto.size}개를 구매했습니다.")
        for (lotto in randomLotto) {
            val machineLottoNumbers = lotto.generate()
            println(machineLottoNumbers)
            randomLottos.add(machineLottoNumbers)
        }
    }

    private fun resultLotto(lottoNumbers: List<Int>, isBonusValid: Int) {
        val lottoResult = Calculator()
        lottoResult.compareNum(lottoNumbers, isBonusValid, randomLottos)
        LottoGameView().printMatchedNumbersCount(lottoResult)
        LottoGameView().printProfitRate(lottoResult.calculateProfitRate())
    }
}
