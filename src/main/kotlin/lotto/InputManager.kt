package lotto

import camp.nextstep.edu.missionutils.Console

class InputManager {
    private fun inputMoney(): String {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }

    fun getMoney(): Int {
        return inputMoney().toInt()
    }
}