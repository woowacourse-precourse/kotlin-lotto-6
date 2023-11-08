package lotto.validation

import lotto.domain.ErrorType
import lotto.domain.LottoRule
import java.lang.NumberFormatException

class CheckInputValidation {

    fun checkIsNumber(userInput: String) {
        try {
            userInput.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(
                ErrorType.IS_NOT_INTEGER.message
            )
        }
    }

    fun checkIsPositiveInteger(number: String) {
        require(number.toInt() > 0) {
            ErrorType.IS_NOT_POSITIVE_INTEGER.message
        }
    }

    fun checkIsCorrectCost(cost: Int) {
        require(
            cost % LottoRule.PRICE.num == 0 &&
                    cost >= LottoRule.PRICE.num
        ) {
            ErrorType.IS_INCORRECT_PURCHASE.message
        }
    }

    fun checkIsLottoNumber(number: String) {
        require(
            number.toInt() in LottoRule.START_INCLUSIVE.num..
                    LottoRule.END_INCLUSIVE.num
        ) {
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
        require(!numbers.contains(bonusNumber)) {
            ErrorType.IS_CONTAIN_DUPLICATES.message
        }
    }

    fun checkLottoCount(userInput: List<String>) {
        require(userInput.size == LottoRule.COUNT.num) {
            ErrorType.IS_NOT_SIX_NUMBERS.message
        }
    }

}