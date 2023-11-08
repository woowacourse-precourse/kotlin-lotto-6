package lotto.domain.lotto.model

import lotto.domain.winningnumber.WinningRank

class Lotties {
    private val lotties: MutableList<Lotto> = mutableListOf()

    fun generateLotties(numberOfLottos: Int) {
        repeat(numberOfLottos) {
            val lotto = Lotto()
            lotties.add(lotto)
        }
    }

    fun printLotties() {
        lotties.forEach { println(it) }
    }

    fun winningResults(winningNumbers: List<Int>, bonusNumber: Int): Map<WinningRank, Int> {
        val results = lotties.groupBy { lotto ->
            val matchCount = lotto.getNumbers().count { it.number in winningNumbers }
            val isBonusMatched = bonusNumber in lotto.getNumbers().map { it.number }
            WinningRank.findByMatchCount(matchCount, isBonusMatched)
        }
        return results.mapValues { it.value.size }
    }

}
