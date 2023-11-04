package lotto.model

import java.lang.NumberFormatException


class Money {

    fun MoneyFomatValidate(money: String) {
        try {
            money.toInt()
        } catch (e: NumberFormatException) {
            error(Constants.ERROR_MONEY_FORMAT)
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