package lotto

object LottoGameManager {
    private var lottoAmount = 0
    fun startLottoGame(){
        println("구입금액을 입력해 주세요.")
        getLottoAmount()
    }

    fun getLottoAmount(){
        lottoAmount = LottoInputHandler.receiveLottoCost() / 1000
    }
}