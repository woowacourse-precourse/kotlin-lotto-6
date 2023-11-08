package lotto.data

import lotto.domain.Validator

open class Lotto(private val numbers: List<Int>) {

    init {
        Validator.getInstance().checkLottoNumberIsCorrect(numbers)
    }

    fun checkGrade(win: Lotto, bonusNum: Int): GRADE {
        val countOfSame = numbers.intersect(win.numbers.toSet()).size
        val isBonusContain = (countOfSame == GRADE.TWO.countOfSame && bonusNum in numbers)
        return GRADE.from(countOfSame, isBonusContain)
    }

    fun checkGrade(winningLotto: WinningLotto): GRADE {
        val countOfSame = countMatchedNum(winningLotto.numbers)
        val isBonusContain = isBonusValid(countOfSame, winningLotto.bonus)
        return GRADE.from(countOfSame, isBonusContain)
    }

    private fun countMatchedNum(nums: List<Int>) = numbers.intersect(nums.toSet()).size

    private fun isBonusValid(countOfSame: Int, bonus: Int) = countOfSame == GRADE.TWO.countOfSame && bonus in numbers

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val LENGTH_OF_NUM = 6
        const val START_NUM = 1
        const val END_NUM = 45
        const val PRICE = 1_000
    }
}
