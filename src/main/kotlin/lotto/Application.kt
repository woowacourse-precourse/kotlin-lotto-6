package lotto

import lotto.domain.Money
import lotto.validator.InputValidator
import lotto.view.InputView

fun main() {
    val money: Money = getInputPurchaseAmount()
}

private fun getInputPurchaseAmount(): Money {
    return try {
        val input = InputView.inputPurchaseAmount()
        InputValidator.validateInputPurchaseAmount(input)
        Money(input.toInt())
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getInputPurchaseAmount()
    }
}
