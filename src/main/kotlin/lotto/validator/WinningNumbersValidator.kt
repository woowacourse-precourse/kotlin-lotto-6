package lotto.validator

class WinningNumbersValidator {
    fun validate(inputWinningNumbers: String) {
        val winningNumbers = splitAndParseToIntList(inputWinningNumbers)
        requireSixNumber(winningNumbers)
        requireValidNumberRange(winningNumbers)
        requireUniqueNumber(winningNumbers)
    }

    private fun splitAndParseToIntList(input: String): List<Int> {
        return try {
            input.split(",").map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자가 아닌 다른 형식을 입력할 수 없습니다.")
        }
    }

    private fun requireSixNumber(numbers: List<Int>) {
        require(numbers.size == 6) { "[ERROR] 6개의 당첨 번호를 입력해 주세요" }
    }

    private fun requireValidNumberRange(numbers: List<Int>) {
        require(numbers.all { number -> number in 1..45 }) { "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

    private fun requireUniqueNumber(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { "[ERROR] 당첨 번호는 중복되지 않아야 합니다." }
    }
}