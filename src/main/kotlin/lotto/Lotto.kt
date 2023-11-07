package lotto

import camp.nextstep.edu.missionutils.Console

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {"[ERROR] : 6개의 숫자를 입력하지 않았습니다. 다시 입력해주세요"}
        require(numbers.all { it in 1..45 }) { "[ERROR] : 1보다 작거나 45보다 큰 수를 입력했습니다. 다시 입력해주세요" }
        require(numbers.distinct().size == 6) { "[ERROR] : 중복된 숫자가 있습니다. 다시 입력해주세요" }
    }

    fun compareCountingMatchedWinningNumber(winningNumber: Lotto): Int {
        return (numbers.toSet().intersect(winningNumber.numbers.toSet()).size)
    }

    fun compareCountingMatchedBonusNumber(bonusNumber: List<Int>): Boolean {
        return numbers.toSet().intersect(bonusNumber.toSet()).size == 1
    }

    fun divideStandard1to6(win: Int, bonus: Boolean): Int {

        val checkValue = listOf(win, bonus)

        return when (checkValue) {
            listOf(3, false) -> 0
            listOf(3, true) -> 0
            listOf(3, false) -> 1
            listOf(4, true) -> 1
            listOf(5, false) -> 2
            listOf(5, true) -> 3
            listOf(6, false) -> 4
            else -> 5
        }
    }

}
