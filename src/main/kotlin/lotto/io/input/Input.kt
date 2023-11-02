package lotto.io.input

import camp.nextstep.edu.missionutils.Console
import lotto.model.Amount

class Input {
    private val validator = InputValidator()

    fun inputPurchaseAmount(): Amount {
        val amount = Console.readLine()
        validator.checkAmount(amount)
        return Amount(amount.toInt())
    }
}