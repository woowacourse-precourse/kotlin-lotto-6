package lotto

import lotto.domain.LottoRank

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
        require(numbers.distinct().size == 6)
    }

    fun compareNumber(winningNumberSet: Pair<List<Int>, Int>): Pair<Int, Boolean> {
        val comparisonNumbers = winningNumberSet.first
        val matchNumbers = numbers.intersect(comparisonNumbers.toSet()).size
        val comparisonBonus = winningNumberSet.second
        val matchBonus = numbers.contains(comparisonBonus)
        return Pair(matchNumbers, matchBonus)
    }

    fun printLottoNumber() {
        println(numbers.joinToString(separator = ", ", prefix = "[", postfix = "]"))
    }

    fun resultOfLotto(compareResult: Pair<Int, Boolean>): LottoRank {
        return LottoRank.fromMatches(compareResult.first, compareResult.second)
    }
}
