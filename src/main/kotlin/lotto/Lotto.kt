package lotto

import lotto.domain.WinningNumber

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }

    fun compareNumber(winningNumber: WinningNumber): Pair<Int, Boolean> {
        val comparisonNumbers = winningNumber.getWinningNumbers()
        val matchNumbers = numbers.intersect(comparisonNumbers.toSet()).size
        val comparisonBonus = winningNumber.getBonusNumber()
        val matchBonus = numbers.contains(comparisonBonus)
        return Pair(matchNumbers, matchBonus)
    }

    fun printLottoNumber() {}

    fun resultOfLotto(result: Pair<Int, Boolean>) {}

}
