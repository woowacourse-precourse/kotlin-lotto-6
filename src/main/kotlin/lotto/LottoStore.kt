package lotto

class LottoStore {

    fun startSellLotto() {
        println("구입 금액을 입력해주세요")
        val seller = LottoSeller().generateLottoNumbers(userInput(User().inputMoney()))
        println("당첨번호를 입력해주세요")
        val validLotto = LottoSeller().isValidateLotto()
        println("보너스 번호를 입력해주세요")
        LottoSeller().checkLottoHasBonusNum(validLotto, User().inputBonusNum())
        println("발행한 로또 번호 및 수량 출력")
        for (lotto in seller) {
            val lottoNumbers = lotto.generate()
            println(lottoNumbers)
        }
    }
}

private fun userInput(money: String): Int {
    return try {
        LottoSeller().checkLottoTicketCount(money)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        userInput(User().inputMoney())
    }
}


/*
val seller = LottoSeller(2).generateLottoNumbers()

    for (lottoGenerator in seller) {
        val lottoNumbers = lottoGenerator.generate()
        println(lottoNumbers)
    }
 */