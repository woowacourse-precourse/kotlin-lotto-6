package lotto

import camp.nextstep.edu.missionutils.Console

object LottoGameManager {
    private var lottoCost = 0
    fun startLottoGame(){
        getLottoCost()
    }

    fun getLottoCost(){
        lottoCost = LottoInputHandler.receiveLottoCost()
    }
}