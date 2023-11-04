package lotto.data

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LENGTH_OF_NUM)
        require(numbers.toSet().size == LENGTH_OF_NUM)
        require(numbers.sorted() == numbers)
    }

    fun checkGrade(win: Lotto, bonusNum: Int): GRADE {
        val (countOfSame, isBonusContain) = count(win.numbers, bonusNum)
        return GRADE.from(countOfSame, isBonusContain)
    }

    private fun count(winningNums: List<Int>, bonus: Int): Pair<Int, Boolean> {
        var countOfSame = 0
        var numIdx = 0
        var winIdx = 0
        val isBonusContain = bonus in numbers

        while (numIdx < LENGTH_OF_NUM && winIdx < LENGTH_OF_NUM) {
            if (numbers[numIdx] == winningNums[winIdx]) {
                countOfSame++
                numIdx++
            } else if (numbers[numIdx] < winningNums[winIdx]) {
                numIdx++
                continue
            }
            winIdx++
        }
        return countOfSame to isBonusContain
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        private const val LENGTH_OF_NUM = 6
    }
}
