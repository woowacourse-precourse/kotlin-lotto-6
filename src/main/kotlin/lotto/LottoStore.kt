package lotto

class LottoStore {
    private val randomLottos = mutableListOf<List<Int>>()
    fun startSellLotto() {
        println("구입 금액을 입력해주세요")
        val seller = LottoSeller().generateLottoNumbers(userInput(User().inputMoney()))
        showRandomLotto(seller)

        println("당첨번호를 입력해주세요")
        val lottoNumbers = LottoSeller().isValidateLotto()
        println("보너스 번호를 입력해주세요")
        val isBonusValid = LottoSeller().checkLottoHasBonusNum(lottoNumbers, User().inputBonusNum())
        Calculator(lottoNumbers, isBonusValid, randomLottos)
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
}

/*
val seller = LottoSeller(2).generateLottoNumbers()

    for (lottoGenerator in seller) {
        val lottoNumbers = lottoGenerator.generate()
        println(lottoNumbers)
    }
 */