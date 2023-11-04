package lotto

import camp.nextstep.edu.missionutils.Console

object LottoGameManager {
    private var lottoCost = 0
    fun startLottoGame(){
        println("구입금액을 입력해 주세요.")
        getLottoCost()
    }

    fun getLottoCost(){
        lottoCost = LottoInputHandler.receiveLottoCost()
    }
}