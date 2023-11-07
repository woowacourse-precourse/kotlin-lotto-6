package lotto.data

import lotto.domain.Validator

open class Lotto(private val numbers: List<Int>) {
    init {
        Validator.getInstance().checkLottoNumberIsCorrect(numbers)
    }

    fun checkGrade(win: Lotto, bonusNum: Int): GRADE {
        val countOfSame = numbers.intersect(win.numbers.toSet()).size
        val isBonusContain = countOfSame == 5 && bonusNum in numbers
        return GRADE.from(countOfSame, isBonusContain)
    }

    fun checkGrade(winningLotto: WinningLotto): GRADE {
        val countOfSame = numbers.intersect(winningLotto.numbers.toSet()).size
        val isBonusContain = countOfSame == 5 && winningLotto.bonus in numbers
        return GRADE.from(countOfSame, isBonusContain)
    }

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
