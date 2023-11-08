package lotto.validator

import lotto.Constants.NUMBERS_SIZE
import lotto.Constants.NUMBER_END_RANGE
import lotto.Constants.NUMBER_START_RANGE

class WinningNumbersValidator {
    fun validate(inputWinningNumbers: String) {
        val winningNumbers = splitAndParseToIntList(inputWinningNumbers)
        requireSixNumbers(winningNumbers)
        requireValidNumberRange(winningNumbers)
        requireUniqueNumbers(winningNumbers)
    }

    private fun splitAndParseToIntList(input: String): List<Int> {
        return try {
            input.split(",").map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_WINNING_NUMBERS_FORMAT_ERROR_MESSAGE)
        }
    }

    private fun requireSixNumbers(numbers: List<Int>) {
        require(numbers.size == NUMBERS_SIZE) { INVALID_WINNING_NUMBERS_SIZE_ERROR_MESSAGE }
    }

    private fun requireValidNumberRange(numbers: List<Int>) {
        require(numbers.all { number ->
            number in NUMBER_START_RANGE..NUMBER_END_RANGE
        }) { WINNING_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE }
    }

    private fun requireUniqueNumbers(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { DUPLICATED_WINNING_NUMBERS_ERROR_MESSAGE }
    }

    companion object {
        private const val INVALID_WINNING_NUMBERS_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 다른 형식을 입력할 수 없습니다."
        private const val INVALID_WINNING_NUMBERS_SIZE_ERROR_MESSAGE = "[ERROR] 6개의 당첨 번호를 입력해 주세요"
        private const val WINNING_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."
        private const val DUPLICATED_WINNING_NUMBERS_ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복되지 않아야 합니다."
    }
}