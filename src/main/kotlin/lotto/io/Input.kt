package lotto.io

import camp.nextstep.edu.missionutils.Console
import lotto.exception.ExceptionChecker

class Input(private val checker: ExceptionChecker = ExceptionChecker()) {

    fun enterPurchaseAmount():Int {
        val purchaseAmount = Console.readLine()
        checker.checkAmount(purchaseAmount)
        return purchaseAmount.toInt()
    }
}
