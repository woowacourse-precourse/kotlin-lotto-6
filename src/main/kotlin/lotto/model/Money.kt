package lotto.model

import lotto.util.Constants
import java.lang.NumberFormatException


class Money {

    fun moneyFormatValidate(money: String) {
        try {
            money.toInt()
        } catch (e: NumberFormatException) {
            println(Constants.ERROR_MONEY_FORMAT)
            throw IllegalArgumentException(Constants.ERROR_MONEY_FORMAT)
        }
    }

    fun moneyRangeValidate(money: String) {
        if (money.toInt() < Constants.THOUSAND) {
            println(Constants.ERROR_MONEY_RANGE)
            throw IllegalArgumentException(Constants.ERROR_MONEY_RANGE)
        }
    }

    fun moneyChangesValidate(money: String) {
        if (money.toInt() % Constants.THOUSAND != Constants.ZERO) {
            println(Constants.ERROR_NO_CHANGES)
            throw IllegalArgumentException(Constants.ERROR_NO_CHANGES)
        }
    }


}