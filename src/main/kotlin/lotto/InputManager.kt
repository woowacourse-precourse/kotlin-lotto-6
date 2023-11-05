package lotto

import lotto.validator.InputMoneyValidator
import lotto.validator.WinningNumbersValidator
import lotto.view.InputView

class InputManager {
    private val inputView = InputView()
    private val inputMoneyValidator = InputMoneyValidator()
    private val winningNumbersValidator = WinningNumbersValidator()

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

    fun getWinningNumbers(): List<Int> {
        return try {
            val inputMoney = inputView.readWinningNumbersFromUser()
            winningNumbersValidator.validate(inputMoney)
            inputMoney.split(",").map { it.trim().toInt() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getWinningNumbers()
        }
    }
}