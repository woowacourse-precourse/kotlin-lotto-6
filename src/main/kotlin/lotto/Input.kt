package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.constant.Exception

object Input {
    fun inputInt(): String {
        return Console.readLine()
    }
    fun inputWinningNumber(): List<String> {
        return Console.readLine().trim().split(",")
    }
}