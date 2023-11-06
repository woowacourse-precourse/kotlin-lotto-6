package lotto.validation

import lotto.domain.LottoManager.Companion.LOTTO_END_INCLUSIVE
import lotto.domain.LottoManager.Companion.LOTTO_START_INCLUSIVE
import java.lang.NumberFormatException

class CheckInputValidation {

    fun checkIsNumber(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun checkIsLottoNumber(number: Int): Boolean{
        return number in LOTTO_START_INCLUSIVE..LOTTO_END_INCLUSIVE
    }

    fun checkIsBlank(userInput: String): Boolean {
        return userInput.isNotEmpty()
    }

    fun checkDuplication(inputList: List<Int>): Boolean{
        val distinctCount = inputList.distinct().count()
        return inputList.size == distinctCount
    }

    fun checkBonusNumberDuplication(
        numbers: List<Int>,
        bonusNumber: Int
    ): Boolean = numbers.contains(bonusNumber)

    fun checkLottoCount(
        userInput: List<String>
    ): Boolean = userInput.size == 6
}