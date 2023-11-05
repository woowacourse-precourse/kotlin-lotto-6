package lotto.controller

import camp.nextstep.edu.missionutils.Console

class LottoController {
    fun inputLottoCost(): Int{ // 로또 구매 금액 입력 받기
        return Console.readLine().toInt()
    }
    fun inputLottoAnswerNumber() : List<String> { // 로또 당첨 번호 입력 받기
        return listOf(*Console.readLine().split(",").toTypedArray<String>())
    }
    fun inputLottoBonusNumber() : String { // 로또 보너스 번호 입력 받기
        return Console.readLine()
    }
}