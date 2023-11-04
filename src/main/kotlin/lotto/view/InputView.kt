package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validate.Validate

class InputView {
    fun inputBuyPrice(): Int {
        val validate = Validate()
        val price = Console.readLine()
        val validatedPrice = validate.validateInputPrice(price)
        return validatedPrice
    }

    fun inputMyNumbers(): String {
        return Console.readLine()
    }
}