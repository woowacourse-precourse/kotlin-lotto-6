package lotto

import camp.nextstep.edu.missionutils.Console

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