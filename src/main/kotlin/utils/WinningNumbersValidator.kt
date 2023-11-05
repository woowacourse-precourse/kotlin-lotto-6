package utils

import lotto.LottoMachine.Companion.END_RANGE_LOTTO_NUM
import lotto.LottoMachine.Companion.LOTTO_NUMBER_COUNT
import lotto.LottoMachine.Companion.START_RANGE_LOTTO_NUM

class WinningNumbersValidator : IntegerInputValidator() {

    fun checkInputValidation(userInput: List<String>): Boolean {
        validateNumbersCount(userInput)
        validateEmptySpace(userInput)
        val numbers = userInput.map { input ->
            input.toInt()
        }
        validateOutOfRange(numbers)
        validateDuplicateNumbers(numbers)
        return true
    }

    fun validateNumbersCount(numbers: List<String>) {
        require(numbers.size == LOTTO_NUMBER_COUNT) { getInvalidNumbersCountErrMsg(LOTTO_NUMBER_COUNT) }
    }

    fun validateEmptySpace(numbers: List<String>) {
        for (number in numbers) {
            this.validateIsString(number)
        }
    }

    fun validateOutOfRange(numbers: List<Int>) {
        for (number in numbers) {
            require(number in START_RANGE_LOTTO_NUM..END_RANGE_LOTTO_NUM) {
                getInvalidRangeLottoNumErrMsg(
                    START_RANGE_LOTTO_NUM,
                    END_RANGE_LOTTO_NUM
                )
            }
        }
    }

    fun validateDuplicateNumbers(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { INPUT_DUPLICATE_NUMBERS_ERR_MSG }
    }

    companion object {
        const val INPUT_DUPLICATE_NUMBERS_ERR_MSG = "중복된 숫자를 입력하실 수 없습니다."
    }
}