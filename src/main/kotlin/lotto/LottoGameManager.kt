package lotto

import lotto.utils.LottoNumbersGenerator

object LottoGameManager {
    private lateinit var lottoGame: LottoGame
    fun startLottoGame(){
        println("구입금액을 입력해 주세요.")
        val lottoAmount = getLottoAmount()
        lottoGame = LottoGame(lottoAmount)
    }

    fun getLottoAmount() : Int = LottoInputHandler.receiveLottoCost() / 1000

}