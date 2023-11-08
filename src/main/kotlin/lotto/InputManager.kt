package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import java.rmi.dgc.Lease

class InputManager(val exceptionManager: ExceptionManager) {
    fun money(): Int {
        while (true) {
            try {
                val str = readLine()
                return exceptionManager.money(str)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun winningNum(): Lotto {
        while (true) {
            try {
                val str = readLine()
                val numbers = exceptionManager.winningNum(str)
                return Lotto(numbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun bonusNum(winningNum: Lotto): Int {
        while (true) {
            try {
                val str = readLine()
                return exceptionManager.bonusNum(str, winningNum)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }
}