package lotto

class Amount(private val amount: String) {

    init {
        require(isNumber()) { throw IllegalArgumentException("$ERROR $INPUT_ONLY_NUMBER") }
    }

    private fun isNumber(): Boolean {
        return amount.all { it.isDigit() }
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val INPUT_ONLY_NUMBER = "숫자만 입력하세요."
    }

}