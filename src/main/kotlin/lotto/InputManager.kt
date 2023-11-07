package lotto

import camp.nextstep.edu.missionutils.Console

class InputManager {
    fun inputMoney(): String {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }
    fun inputWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val nums = Console.readLine().split(",")
        return nums.map { it.toInt() }
    }
    fun inputBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val num = Console.readLine()
        return num.toInt()
    }

}