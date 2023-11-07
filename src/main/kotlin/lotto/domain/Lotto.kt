package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun matchNumbers(luckyNumbers: List<Int>): Int {
        var count = 0

        luckyNumbers.forEach { number ->
            if (numbers.contains(number)) count++
        }

        return count
    }

    fun hasBonusNumber(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)
}
