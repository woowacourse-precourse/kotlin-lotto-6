package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validate.ValidateNumbers
import lotto.validate.ValidatePrice

object InputView {
    fun inputBuyPrice(): Int {
        val validatePrice = ValidatePrice()
        val price = Console.readLine()

        return validatePrice.validateInputPrice(price)
    }

    fun inputMyNumbers(): String {
        val validateNumbers = ValidateNumbers()
        val myNumbers = Console.readLine()

        return validateNumbers.validateInputNumbers(myNumbers)
    }

    fun inputBonusNumber(): Int {
        return Console.readLine().toInt()
    }
}