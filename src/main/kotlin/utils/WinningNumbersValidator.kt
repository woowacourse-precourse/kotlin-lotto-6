package utils

import lotto.LottoMachine.Companion.LOTTO_NUMBER_COUNT

class WinningNumbersValidator : IntegerInputValidator() {

    fun checkInputValidation(userInput: List<String>): Boolean {
        validateNumbersCount(userInput)
        validateEmptySpace(userInput)

        val numbers = userInput.map { input -> input.toInt() }
        validateOutOfRangeNumbers(numbers)
        validateDuplicateNumbers(numbers)
        return true
    }

    fun validateNumbersCount(numbers: List<String>) {
        require(numbers.size == LOTTO_NUMBER_COUNT) { getInvalidNumbersCountErrMsg(LOTTO_NUMBER_COUNT) }
    }

    fun validateEmptySpace(numbers: List<String>) {
        numbers.forEach { super.validateIsString(it) }
    }

    fun validateOutOfRangeNumbers(numbers: List<Int>) {
        numbers.forEach { super.validateOutOfRange(it) }
    }

    fun validateDuplicateNumbers(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { INPUT_DUPLICATE_NUMBERS_ERR_MSG }
    }

    companion object {
        const val INPUT_DUPLICATE_NUMBERS_ERR_MSG = "중복된 숫자를 입력하실 수 없습니다."
    }
}