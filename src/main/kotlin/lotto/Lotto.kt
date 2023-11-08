package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun printNumbers() : List<Int>
    {
        return numbers.sorted()
    }

    fun getMatchedNumbers(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers).count()
    }

    fun containsNumber(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }
    fun containsBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber == numbers.last()
    }

}
