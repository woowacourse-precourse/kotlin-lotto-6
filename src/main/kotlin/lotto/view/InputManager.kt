package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Error

object InputManager {
    private val SEPERATOR = ","
    fun getPurchaseInput(): Int {
        OutputManager.printInputPurchaseAmount()
        return runCatching {
            requireNotNull(Console.readLine().toIntOrNull()) { Error.NotNumber.message }
        }.getOrElse {
            println(it.message)
            getPurchaseInput()
        }
    }

    fun getWinningNumber(): List<Int> {
        OutputManager.printInputWinningNum()
        return kotlin.runCatching {
            Console.readLine().split(SEPERATOR)
                .map { number -> requireNotNull(number.toIntOrNull()) }
        }.getOrElse {
            println(it.message)
            getWinningNumber()
        }
    }
}