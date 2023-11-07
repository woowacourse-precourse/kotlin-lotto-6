package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Error

object InputManager {
    fun getPurchaseInput(): Int {
        OutputManager.printInputPurchaseAmount()
        return runCatching {
            requireNotNull(Console.readLine().toIntOrNull()) { Error.NotNumber.message }
        }.getOrElse {
            println(it.message)
            getPurchaseInput()
        }
    }
}