package lotto

class ExceptionManager {
    fun money(str: String): Int {
        val number = str.safeToInt()
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
        val number = str.safeToInt()
        lottoNumberInRange(number)
        require(!winningNum.contains(number)) { print("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.") }
        return number
    }

    fun String.safeToInt(): Int {
        try {
            return this.toInt()
        } catch (e: NumberFormatException) {
            print("[ERROR] 입력값은 숫자여야 합니다.")
            throw IllegalArgumentException()
        }
    }

    private fun convertToIntList(str: String): List<Int> {
        try {
            return str.split(",").map { it.safeToInt() }
        } catch (e: NumberFormatException) {
            print("[ERROR] 올바른 형식의 숫자 리스트가 아닙니다.")
            throw IllegalArgumentException()
        }
    }

    private fun lottoNumberInRange(number: Int) {
        require(number in 1..45) { print("[ERROR] 1~45 이내의 숫자를 입력 해야 합니다.") }
    }
}