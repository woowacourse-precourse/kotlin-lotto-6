package util

object Validator {
    fun containsOnlyDigits(price: String) {
        require(price.all { it.isDigit() }) { "[ERROR] 숫자만 입력이 가능합니다." }
    }
}
