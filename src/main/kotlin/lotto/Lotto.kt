package lotto

import lotto.domain.WinningNumber

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun compareNumber(winningNumber: WinningNumber): Pair<Int, Boolean> {
        val comparisonNumbers = winningNumber.getWinningNumbers()
        val matchNumbers = numbers.intersect(comparisonNumbers.toSet()).size
        val comparisonBonus = winningNumber.getBonusNumber()
        val matchBonus = numbers.contains(comparisonBonus)
        return Pair(matchNumbers, matchBonus)
    }

    fun printLottoNumber() {
        println(numbers.joinToString(separator = ", ", prefix = "[", postfix = "]"))
    }

    fun resultOfLotto(result: Pair<Int, Boolean>): String {
        val (matchNumbers, matchBonus) = result
        return when {
            matchNumbers == 6 -> "1등"
            matchNumbers == 5 && matchBonus -> "2등"
            matchNumbers == 5 -> "3등"
            matchNumbers == 4 -> "4등"
            matchNumbers == 3 -> "5등"
            else -> "낙첨"
        }
    }

}
