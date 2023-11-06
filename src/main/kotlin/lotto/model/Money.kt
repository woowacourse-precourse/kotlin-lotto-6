package lotto.model

import lotto.controller.LottoMachine
import java.lang.NumberFormatException


class Money {
    fun inputMoneyValidate(money: String) {
        try {
            moneyFormatValidate(money)
            moneyRangeValidate(money)
            moneyChangesValidate(money)
        } catch (e: IllegalArgumentException) {
            LottoMachine().start()
        }
    }

    private fun moneyFormatValidate(money: String) {
        try {
            money.toInt()
        } catch (e: NumberFormatException) {
            println(Constants.ERROR_MONEY_FORMAT)
            throw IllegalArgumentException(Constants.ERROR_MONEY_FORMAT)
        }
    }

    private fun moneyRangeValidate(money: String) {
        if (money.toInt() < Constants.THOUSAND) {
            println(Constants.ERROR_MONEY_RANGE)
            throw IllegalArgumentException(Constants.ERROR_MONEY_RANGE)
        }
    }

    private fun moneyChangesValidate(money: String) {
        if (money.toInt() % Constants.THOUSAND != Constants.ZERO) {
            println(Constants.ERROR_NO_CHAGES)
            throw IllegalArgumentException(Constants.ERROR_NO_CHAGES)
        }
    }


}