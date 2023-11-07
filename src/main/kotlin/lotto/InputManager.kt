package lotto

import camp.nextstep.edu.missionutils.Console.readLine

class InputManager {
    val exceptionManager = ExceptionManager()
    fun money(): Int {
        val moneyString = readLine()
        return exceptionManager.money(moneyString)
    }

    fun winningNum(): Lotto {
        val str = readLine()
        val numbers = exceptionManager.winningNum(str)
        return Lotto(numbers)
    }
}