package lotto.viewmodel

import lotto.observer.InputMoneyErrorListener
import lotto.observer.InputMoneyListener

class InputMoneyViewModel {
    lateinit var inputMoneyListener: InputMoneyListener
    lateinit var inputMoneyErrorListener: InputMoneyErrorListener
    private val inputValidator = InputValidator()
    private var money = 0

    fun updateMoney(money: String) {
        try { test(money) }
        catch (e: IllegalArgumentException) { inputMoneyErrorListener.onMoneyError(e.message!!) }
    }

    private fun test(money: String) {
        this.money = validatePrice(money)
        inputMoneyListener.inputMoneyListener(this.money)
    }

    private fun validatePrice(money: String): Int {
        inputValidator.moneyValidator(money)
        return money.toInt()
    }
}