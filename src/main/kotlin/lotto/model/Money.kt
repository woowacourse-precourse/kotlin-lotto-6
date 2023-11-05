package lotto.model

import lotto.controller.LottoMachine
import java.lang.NumberFormatException


class Money {

    fun MoneyFomatValidate(money: String) {
        try {
            money.toInt()
        } catch (e: NumberFormatException) {
            println(Constants.ERROR_MONEY_FORMAT)
            LottoMachine().moneyInput()
        }
    }

    fun MoneyChangesValidate(money: String) {
        if (money.toInt() % Constants.THOUSAND != Constants.ZERO) {
            throw IllegalArgumentException(Constants.ERROR_NO_CHAGES)
        }
    }

    fun MoneyRangeValidate(money: String) {
        if (money.toInt() < Constants.THOUSAND) {
            throw IllegalArgumentException(Constants.ERROR_MONEY_RANGE)
        }
    }
}