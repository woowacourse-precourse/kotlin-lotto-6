package lotto.util

import lotto.constants.LottoConstants
import lotto.exception.IllegalBonusException
import lotto.exception.IllegalMoneyException
import lotto.exception.IllegalNumbersException
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
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
        val lottoNumbers: List<Int>

        try {
            lottoNumbers = inputString.split(",").map { it.toInt() }.toList()
        } catch (e: IllegalNumbersException) {
            throw IllegalNumbersException.numbersNotList
        } catch (e: NumberFormatException) {
            throw IllegalNumbersException.numbersNotRange
        }
        require(
            lottoNumbers.filter { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }.size == 6
        ) {
            throw IllegalNumbersException.numbersNotList
        }
        require(lottoNumbers.distinct().size == 6) {
            throw IllegalNumbersException.numbersDuplicate
        }

        return Lotto(lottoNumbers)
    }

    fun checkInputBonus(lotto: Lotto, inputString: String): Int {
        val bonusNumber: Int

        try {
            bonusNumber = inputString.toInt()
        } catch (e: IllegalBonusException) {
            throw IllegalBonusException.bonusNotRange
        } catch (e: NumberFormatException) {
            throw IllegalBonusException.bonusNotRange
        }
        require(bonusNumber in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
            throw IllegalBonusException.bonusNotRange
        }
        require(!lotto.getLottoNumbers().contains(bonusNumber)) {
            throw IllegalBonusException.bonusDuplicate
        }

        return bonusNumber
    }
}