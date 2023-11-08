package lotto.validation

import lotto.domain.LottoManager.Companion.LOTTO_COST
import lotto.domain.LottoManager.Companion.LOTTO_COUNT
import lotto.domain.LottoManager.Companion.LOTTO_END_INCLUSIVE
import lotto.domain.LottoManager.Companion.LOTTO_START_INCLUSIVE
import java.lang.NumberFormatException

class CheckInputValidation {

    fun checkIsNumber(userInput: String) {
        try {
            userInput.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(
                IS_NOT_INTEGER
            )
        }
    }

    fun checkIsPositiveInteger(number: String) {
        require(number.toInt() > 0) {
            IS_NOT_POSITIVE_INTEGER
        }
    }

    fun checkIsCorrectCost(cost: Int) {
        require(cost % LOTTO_COST != 0) {
            IS_INCORRECT_PURCHASE
        }
    }

    fun checkIsLottoNumber(number: String) {
        require(number.toInt() in LOTTO_START_INCLUSIVE..LOTTO_END_INCLUSIVE) {
            IS_INCORRECT_NUMBER
        }
    }

    fun checkIsBlank(userInput: String) {
        require(userInput.isNotEmpty()) {
            IS_BLANK
        }
    }

    fun checkDuplication(inputList: List<Int>) {
        val distinctCount = inputList.distinct().count()
        require(inputList.size == distinctCount) {
            IS_CONTAIN_DUPLICATES
        }
    }

    fun checkBonusNumberDuplication(
        numbers: Set<Int>,
        bonusNumber: Int
    ) {
        require(numbers.contains(bonusNumber)) {
            IS_CONTAIN_DUPLICATES
        }
    }

    fun checkLottoCount(
        userInput: List<String>
    ) {
        require(userInput.size == LOTTO_COUNT) {
            IS_NOT_SIX_NUMBERS
        }
    }

    companion object {
        const val IS_NOT_INTEGER = "입력 값이 숫자가 아닙니다."
        const val IS_NOT_POSITIVE_INTEGER = "입력 값이 정수가 아닙니다."
        const val IS_CONTAIN_DUPLICATES = "중복 된 로또 번호가 있습니다."
        const val IS_INCORRECT_NUMBER = "1~45 범위의 로또 번호가 아닙니다."
        const val IS_INCORRECT_PURCHASE = "올바르지 않은 구매 금액입니다.(1,000원 단위 입력)"
        const val IS_BLANK = "빈 값이 입력 되었습니다."
        const val IS_NOT_SIX_NUMBERS = "로또 번호가 6개가 아닙니다."
    }
}