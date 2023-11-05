package lotto.controller

import lotto.util.Constants.INPUT_MONEY
import lotto.util.Validation
import lotto.view.Input

class LottoGame {

    private val input = Input()
    private val validate = Validation()

    fun play() {
        println(INPUT_MONEY)
        val amount = checkInputAmount()
    }

    private fun checkInputAmount(): Int {
        return try {
            val amount = input.inputPurchaseAmount()
            validate.validatePurchaseAmount(amount)
            amount.toInt()
        } catch (e: IllegalArgumentException) {
            println(e)
            checkInputAmount()
        }
    }
}