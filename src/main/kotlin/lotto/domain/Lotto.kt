package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun matchCount(winNumbers: List<Int>) {
//        winNumbers = numbers
    }

    fun matchBonusNumber(bonusNumber: Int): Boolean {
//        numbers = bonusNumber
        return false
    }
}
