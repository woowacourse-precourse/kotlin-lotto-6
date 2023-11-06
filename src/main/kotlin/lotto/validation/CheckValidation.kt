package lotto.validation

import lotto.model.WinningLotto
import java.lang.NumberFormatException

class CheckValidation {

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


    companion object {
        const val LOTTO_START_INCLUSIVE = 1
        const val LOTTO_END_INCLUSIVE = 45
    }
}