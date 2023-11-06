package lotto.util

import lotto.constants.LottoConstants
import lotto.exception.IllegalMoneyException

object InputChecker {

    fun checkInputMoney(inputString: String): Long {
        val money: Long
        try {
            money = inputString.toLong()
        } catch (e: NumberFormatException) {
            throw IllegalMoneyException.moneyNotNumber
        }
        require(money >= LottoConstants.LOTTO_PRICE) {
            throw IllegalMoneyException.moneyUnderPrice
        }
        require((money % LottoConstants.LOTTO_PRICE).toInt() == 0) {
            throw IllegalMoneyException.moneyNotDivide
        }
        return money
    }
}