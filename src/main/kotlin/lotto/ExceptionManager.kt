package lotto

class ExceptionManager {
    fun money(str: String) {
        var number = str.toInt()
        require(number >= 0) { "[ERROR] 구입 금액은 0 이상이어야 합니다." }
        require(number % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
    }

    private fun String.toInt(str: String): Int {
        try {
            return str.toInt()
        }
        catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.")
        }
    }
}