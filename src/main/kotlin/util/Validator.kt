package util

object Validator {
    fun containsOnlyDigits(price: String) {
        require(price.all { it.isDigit() }) { Error.INPUT_ONLY_NUMBER.message }
    }

    private enum class Error(val message: String) {
        INPUT_ONLY_NUMBER("[ERROR] 숫자만 입력이 가능합니다."),
    }
}
