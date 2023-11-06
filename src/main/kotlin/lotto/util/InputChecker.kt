package lotto.util

import lotto.constants.LottoConstants
import lotto.exception.IllegalBonusException
import lotto.exception.IllegalMoneyException
import lotto.exception.IllegalNumbersException
import lotto.model.Lotto
import java.lang.NumberFormatException

object InputChecker {

    fun checkInputMoney(inputString: String): Long {
        val money: Long
        try {
            money = inputString.toLong()
        } catch (e: IllegalMoneyException) {
            throw IllegalMoneyException.moneyNotNumber
        } catch (e: NumberFormatException) {
            throw IllegalMoneyException.moneyTooMuch
        }
        require(money >= LottoConstants.LOTTO_PRICE) {
            throw IllegalMoneyException.moneyUnderPrice
        }
        require((money % LottoConstants.LOTTO_PRICE).toInt() == 0) {
            throw IllegalMoneyException.moneyNotDivide
        }
        return money
    }

    fun checkInputNumbers(inputString: String): Lotto {
        val lottoNumbers: Lotto

        try {
            lottoNumbers = Lotto(inputString.split(",").map { it.toInt() }.toList())
        } catch (e: IllegalNumbersException) {
            throw IllegalNumbersException.numbersNotList
        }
        return lottoNumbers
    }

    fun checkInputBonus(inputString: String): Int {
        val bonusNumber: Int
        try {
            bonusNumber = inputString.toInt()
        } catch (e: IllegalBonusException) {
            throw IllegalBonusException.bonusNotNumber
        }
        return bonusNumber
    }
}