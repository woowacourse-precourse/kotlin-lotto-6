package lotto

import lotto.validator.InputMoneyValidator
import lotto.view.InputView

class InputManager {
    private val inputView = InputView()
    private val inputMoneyValidator = InputMoneyValidator()

    fun getInputMoney(): String {
        return try {
            val inputMoney = inputView.readInputMoneyFromUser()
            inputMoneyValidator.validate(inputMoney)
            inputMoney
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getInputMoney()
        }
    }
}