package lotto

import exception.Exception
import ui.Input.inputMoney

class Buy {
    fun buyLotto(): Int {
        val inputMoney = inputMoney()
        return inputMoney / 1000
    }

    fun validateMoney(money: String) {
        if (money.toInt() % 1000 != 0) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_MONEY)
        }
        if (!money.all { Character.isDigit(it) }) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_MONEY_TYPE)
        }
    }
}