package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "$ERROR_PREFIX 로또 번호는 총 6개여야 합니다."
        }
        require(numbers.distinct().size == 6) {
            "$ERROR_PREFIX 중복된 숫자가 존재합니다."
        }
    }

    fun matchNumbers(luckyNumbers: List<Int>): Int {
        var count = 0

        luckyNumbers.forEach { number ->
            if (numbers.contains(number)) count++
        }

        return count
    }

    fun hasBonusNumber(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)

    companion object {
        private const val ERROR_PREFIX: String = "[ERROR]"
    }
}
