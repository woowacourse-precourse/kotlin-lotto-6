package lotto

class ExceptionManager {
    fun money(str: String): Int {
        var number = str.toInt()
        require(number >= 0) { "[ERROR] 구입 금액은 0 이상이어야 합니다." }
        require(number % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
        return number
    }

    fun winningNum(str: String): List<Int> {
        return convertToIntList(str)
    }

    private fun String.toInt(str: String): Int {
        try {
            return str.toInt()
        }
        catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 입력값은 숫자여야 합니다.")
        }
    }

    private fun convertToIntList(str: String): List<Int> {
        try {
            val numbers = str.split(",").map { it.toInt() }
            return numbers
        }
        catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 올바른 형식의 숫자 리스트가 아닙니다.")
        }
    }
}