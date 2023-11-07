package lotto.util

import lotto.constants.LottoConstants
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER
import lotto.exception.IllegalBonusException
import lotto.exception.IllegalMoneyException
import lotto.exception.IllegalNumbersException

object InputChecker {

    fun checkInputMoney(inputString: String, returnCode: Long): Long {
        val money: Long

        require(inputString.length <= 18) {
            println(IllegalMoneyException.moneyTooMuch)
            return returnCode
        }
        require(inputString.matches(Regex("\\d+"))) {
            println(IllegalMoneyException.moneyNotNumber)
            return returnCode
        }
        money = inputString.toLong()
        require(money >= LottoConstants.LOTTO_PRICE) {
            println(IllegalMoneyException.moneyUnderPrice)
            return returnCode
        }
        require((money % LottoConstants.LOTTO_PRICE).toInt() == 0) {
            println(IllegalMoneyException.moneyNotDivide)
            return returnCode
        }

        return money
    }

    fun checkInputNumbers(inputString: String, returnCode: List<Int>): List<Int> {
        val lottoNumbers: List<Int>

        require(inputString.split(",").size == 6) {
            println(IllegalNumbersException.numbersNotList)
            return returnCode
        }
        require(inputString.split(",").filter { it.matches(Regex("\\d+")) }.size == 6) {
            println(IllegalNumbersException.numbersNotRange)
            return returnCode
        }
        lottoNumbers = inputString.split(",").map { it.toInt() }.toList()
        require(lottoNumbers.filter { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }.size == 6) {
            println(IllegalNumbersException.numbersNotRange)
            return returnCode
        }
        require(lottoNumbers.distinct().size == 6) {
            println(IllegalNumbersException.numbersDuplicate)
            return returnCode
        }

        return lottoNumbers
    }

    fun checkInputBonus(lottoNumbers: List<Int>, inputString: String, returnCode: Int): Int {
        val bonusNumber: Int

        require(inputString.matches(Regex("\\d+"))) {
            println(IllegalBonusException.bonusNotRange)
            return returnCode
        }
        bonusNumber = inputString.toInt()
        require(bonusNumber in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
            println(IllegalBonusException.bonusNotRange)
            return returnCode
        }
        require(!lottoNumbers.contains(bonusNumber)) {
            println(IllegalBonusException.bonusDuplicate)
            return returnCode
        }

        return bonusNumber
    }
}