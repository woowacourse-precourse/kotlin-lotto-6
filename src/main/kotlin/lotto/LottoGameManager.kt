package lotto

import lotto.utils.LottoNumbersGenerator

object LottoGameManager {
    private var lottoAmount = 0
    fun startLottoGame(){
        println("구입금액을 입력해 주세요.")
        getLottoAmount()
        repeat(lottoAmount){
            Lotto(LottoNumbersGenerator.generateLottoNumbers())
        }
    }

    fun getLottoAmount(){
        lottoAmount = LottoInputHandler.receiveLottoCost() / 1000
    }
}