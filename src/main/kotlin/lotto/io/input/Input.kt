package lotto.io.input

import camp.nextstep.edu.missionutils.Console

class Input {
    private val validator = InputValidator()

    fun inputPurchaseAmount() {
        val purchaseAmount = Console.readLine()
        validator.checkPurchaseAmount(purchaseAmount)
    }
}