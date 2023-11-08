package domain.lotto

class BonusNumber(
    private val number: String,
    private val winningNumber: List<Int> = emptyList(),
) {

    init {
        require(isNumber()) { "$ERROR $INPUT_ONLY_NUMBER" }
        require(numbersOutOfRange()) { "$ERROR $BONUS_NUMBER_RANGE" }
        require(isIncludeInWinningNumber()) { "$ERROR $NOT_INCLUDE_WINNING_NUMBER" }
    }

    private fun isNumber(): Boolean {
        return number.toIntOrNull() != null
    }

    private fun numbersOutOfRange(): Boolean {
        return number.toInt() in BONUS_MIN_NUMBER..BONUS_MAX_NUMBER
    }

    private fun isIncludeInWinningNumber(): Boolean {
        return !winningNumber.contains(number.toInt())
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val INPUT_ONLY_NUMBER = "보너스 번호는 숫자만 입력 가능합니다."
        const val BONUS_NUMBER_RANGE = "보너스 번호는 1부터 45사이의 숫자여야 합니다."
        const val NOT_INCLUDE_WINNING_NUMBER = "보너스 번호는 당첨 번호에 포함된 숫자일 수 없습니다."
        const val BONUS_MIN_NUMBER = 1
        const val BONUS_MAX_NUMBER = 45
    }

}