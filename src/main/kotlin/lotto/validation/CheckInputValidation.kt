package lotto.validation

import lotto.domain.ErrorType
import lotto.domain.LottoManager.Companion.LOTTO_END_INCLUSIVE
import lotto.domain.LottoManager.Companion.LOTTO_START_INCLUSIVE
import java.lang.NumberFormatException

class CheckInputValidation {

    fun checkIsNumber(userInput: String) {
        try {
            userInput.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(
                ErrorType.IS_NOT_POSITIVE_INTEGER.message
            )
        }
    }

    fun checkIsLottoNumber(number: String) {
        require(number.toInt() in LOTTO_START_INCLUSIVE..LOTTO_END_INCLUSIVE) {
            ErrorType.IS_INCORRECT_NUMBER.message
        }
    }

    fun checkIsBlank(userInput: String) {
        require(userInput.isNotEmpty()) {
            ErrorType.IS_BLANK.message
        }
    }

    fun checkDuplication(inputList: List<Int>) {
        val distinctCount = inputList.distinct().count()
        require(inputList.size == distinctCount) {
            ErrorType.IS_CONTAIN_DUPLICATES.message
        }
    }

    fun checkBonusNumberDuplication(
        numbers: Set<Int>,
        bonusNumber: Int
    ) {
        require(numbers.contains(bonusNumber)) {
            ErrorType.IS_CONTAIN_DUPLICATES.message
        }
    }

    fun checkLottoCount(
        userInput: List<String>
    ) {
        require(userInput.size == 6) {
            ErrorType.IS_NOT_SIX_NUMBERS.message
        }
    }
}