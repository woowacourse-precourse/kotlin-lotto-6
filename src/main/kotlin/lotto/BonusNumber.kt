package lotto

class BonusNumber(
    private val number: String,
) {

    init {
        require(isNumber()) { "$ERROR $INPUT_ONLY_NUMBER" }
    }

    private fun isNumber(): Boolean {
        return number.toIntOrNull() != null
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val INPUT_ONLY_NUMBER = "보너스 번호는 숫자만 입력 가능합니다."
    }

}