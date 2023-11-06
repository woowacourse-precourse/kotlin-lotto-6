package lotto

import camp.nextstep.edu.missionutils.Console

class InputManager {
    fun inputMoney(): String? {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }
    fun inputWinningNumber(): List<String> {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine().split(",")
    }
    fun inputBonusNumber(): String? {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine()
    }

}