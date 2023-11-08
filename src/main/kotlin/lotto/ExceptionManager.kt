package lotto

class ExceptionManager {
    fun money(str: String): Int {
        var number = str.toInt()
        require(number >= 0) { "[ERROR] 구입 금액은 0 이상이어야 합니다." }
        require(number % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
        return number
    }

    fun winningNum(str: String): List<Int> {
        val numbers = convertToIntList(str)
        numbers.forEach { lottoNumberInRange(it) }
        return numbers
    }

    fun bonusNum(str: String, winningNum: Lotto): Int {
        val number = str.toInt()
        lottoNumberInRange(number)
        require(!winningNum.contains(number)) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
        return number
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
            return str.split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 올바른 형식의 숫자 리스트가 아닙니다.")
        }
    }

    private fun lottoNumberInRange(number: Int) {
        require(number in 1..45) {"[ERROR] 1~45 이내의 숫자를 입력 해야 합니다."}
    }
}