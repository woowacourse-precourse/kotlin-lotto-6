package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validate.ValidatePrice

class InputView {
    fun inputBuyPrice(): Int {
        val validatePrice = ValidatePrice()
        val price = Console.readLine()
        val validatedPrice = validatePrice.validateInputPrice(price)
        return validatedPrice
    }

    fun inputMyNumbers(): String {
        return Console.readLine()
    }
}