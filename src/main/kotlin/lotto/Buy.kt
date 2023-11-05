package lotto

import exception.Exception
import ui.Input
import java.util.SimpleTimeZone

class Buy {
    fun buyLotto(): Int {
        val inputMoney = Input().inputMoney()
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