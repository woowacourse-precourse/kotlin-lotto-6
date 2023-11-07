package lotto

class BonusNumber(
    private val number: String,
) {

    init {
        require(isNumber()) { "$ERROR $INPUT_ONLY_NUMBER" }
        require(numbersOutOfRange()) { "$ERROR $BONUS_NUMBER_RANGE" }
    }

    private fun isNumber(): Boolean {
        return number.toIntOrNull() != null
    }

    private fun numbersOutOfRange(): Boolean {
        return number.toInt() in 1..45
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val INPUT_ONLY_NUMBER = "보너스 번호는 숫자만 입력 가능합니다."
        const val BONUS_NUMBER_RANGE = "보너스 번호는 1부터 45사이의 숫자여야 합니다."
    }

}