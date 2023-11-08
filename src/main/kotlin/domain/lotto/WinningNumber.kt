package domain.lotto

class WinningNumber(private val numbers: String) {

    private val winningNumbers = numbers.split(",")

    init {
        require(checkSize()) { "$ERROR $WINNING_NUMBER_ONLY_SIX_DIGITS" }
        require(checkNumbersOfCommas()) { "$ERROR $PLEASE_SEPARATE_NUMBERS_COMMAS" }
        require(isNumberOrNull()) { "$ERROR $INPUT_ONLY_NUMBER" }
        require(numbersOutOfRange()) { "$ERROR $WINNING_NUMBER_RANGE" }
        require(checkDuplicateNumbers()) { "$ERROR $WINNING_NUMBER_CANNOT_DUPLICATE" }
    }

    private fun checkSize(): Boolean {
        return winningNumbers.size == WINNING_NUMBER_SIZE
    }

    private fun checkNumbersOfCommas(): Boolean {
        return numbers.count { it == ',' } == COMMA_SIZE
    }

    private fun isNumberOrNull(): Boolean {
        return winningNumbers.all { it.toIntOrNull() != null }
    }

    private fun numbersOutOfRange(): Boolean {
        return winningNumbers.all { it.toInt() in WINNING_MIN_NUMBER..WINNING_MAX_NUMBER }
    }

    private fun checkDuplicateNumbers(): Boolean {
        return winningNumbers.distinct().size == winningNumbers.size
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val WINNING_NUMBER_ONLY_SIX_DIGITS = "당첨 번호는 6자리여야 합니다."
        const val PLEASE_SEPARATE_NUMBERS_COMMAS = "당첨 번호는 쉼표(,) 기준으로 구분해주세요."
        const val INPUT_ONLY_NUMBER = "당첨 번호는 숫자만 입력 가능합니다."
        const val WINNING_NUMBER_RANGE = "당첨 번호는 1부터 45사이의 숫자여야 합니다."
        const val WINNING_NUMBER_CANNOT_DUPLICATE = "당첨 번호는 중복될 수 없습니다."
        const val WINNING_NUMBER_SIZE = 6
        const val WINNING_MIN_NUMBER = 1
        const val WINNING_MAX_NUMBER = 45
        const val COMMA_SIZE = 5
    }

}