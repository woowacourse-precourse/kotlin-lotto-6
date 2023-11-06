package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Error

object InputManager {

    private val outputManager = OutputManager()
    fun getPurchaseInput(): Int {
        outputManager.printInputPurchaseAmount()
        return runCatching {
            requireNotNull(Console.readLine().toIntOrNull()) { Error.NotNumber.message }
        }.getOrElse {
            println(it.message)
            getPurchaseInput()
        }
    }
}