package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validate.ValidateNumbers
import lotto.validate.ValidatePrice

object InputView {
    fun inputBuyPrice(): Int {
        val validatePrice = ValidatePrice()
        val price = Console.readLine()

        val validatedPrice = validatePrice.validateInputPrice(price)
        return validatedPrice
    }

    fun inputMyNumbers(): String {
        val validateNumbers = ValidateNumbers()
        val myNumbers = Console.readLine()

        val validatedNumbers = validateNumbers.validateInputNumbers(myNumbers)
        return validatedNumbers
    }
}