package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoModel

class LottoController { // 입력 처리, model과 view 연결

    fun inputLottoCost(): Int{ // 로또 구매 금액 입력 받기
        return Console.readLine().toInt()
    }
    fun inputLottoAnswerNumber() : String { // 로또 당첨 번호 입력 받기
        return Console.readLine()
    }
    fun inputLottoBonusNumber() : Int { // 로또 보너스 번호 입력 받기
        return Console.readLine().toInt()
    }
}