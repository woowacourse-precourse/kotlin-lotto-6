package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun matchCount(winningLotto: Lotto): Any {
        return numbers.intersect(winningLotto.getNumbers().toSet()).size
    }

    fun matchBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
