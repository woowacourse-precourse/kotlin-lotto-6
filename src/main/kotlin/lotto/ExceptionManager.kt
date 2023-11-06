package lotto

class ExceptionManager {
    fun money(str: String) {
        var number = 0
        try {
            number = str.toInt()
        }
        catch (e: NumberFormatException){
            throw IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.")
        }
        require(number >= 0) { "[ERROR] 구입 금액은 0 이상이어야 합니다." }
        require(number % 0 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
    }
}