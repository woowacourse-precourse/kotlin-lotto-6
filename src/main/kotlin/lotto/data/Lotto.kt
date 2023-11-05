package lotto.data

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LENGTH_OF_NUM)
        require(numbers.toSet().size == LENGTH_OF_NUM)
        require(numbers.sorted() == numbers)
    }

    fun checkGrade(win: Lotto, bonusNum: Int): GRADE {
        val countOfSame = numbers.intersect(win.numbers.toSet()).size
        val isBonusContain = bonusNum in numbers
        return GRADE.from(countOfSame, isBonusContain)
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        private const val LENGTH_OF_NUM = 6
    }
}
