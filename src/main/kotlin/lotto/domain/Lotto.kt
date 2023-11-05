package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size)
    }

    fun matchCount(winNumbers: Set<Int>) {
//        winNumbers = numbers
    }

    fun matchBonusNumber(bonusNumber: Int): Boolean {
//        numbers = bonusNumber
        return false
    }
}
