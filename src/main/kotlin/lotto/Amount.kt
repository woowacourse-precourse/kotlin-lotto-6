package lotto

class Amount(private val amount: String) {

    init {
        require(isNumber()) { throw IllegalArgumentException("$ERROR $INPUT_ONLY_NUMBER") }
        require(isBelowZero()) {throw IllegalArgumentException("$ERROR $INPUT_ONLY_MORE_THAN_ZERO")}
    }

    private fun isNumber(): Boolean {
        return amount.all { it.isDigit() }
    }

    private fun isBelowZero(): Boolean {
        val value = amount.toIntOrNull()
        return value != null && value > 0
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val INPUT_ONLY_NUMBER = "숫자만 입력하세요."
        const val INPUT_ONLY_MORE_THAN_ZERO = "구입 금액으로 0 이하의 숫자는 입력할 수 없습니다."
    }

}