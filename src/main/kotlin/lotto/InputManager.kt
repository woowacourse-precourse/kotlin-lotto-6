package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import java.rmi.dgc.Lease

class InputManager(val exceptionManager: ExceptionManager) {
    fun money(): Int {
        val str = readLine()
        return exceptionManager.money(str)
    }

    fun winningNum(): Lotto {
        val str = readLine()
        val numbers = exceptionManager.winningNum(str)
        return Lotto(numbers)
    }

    fun bonusNum(winningNum: Lotto): Int {
        val str = readLine()
        return exceptionManager.bonusNum(str, winningNum)
    }
}