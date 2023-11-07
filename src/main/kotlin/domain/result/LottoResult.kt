package domain.result

class LottoResult(
    private val lotties: List<List<Int>>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    fun getFinalResult(): FinalResult {

    }

    fun getWinningData(): List<Map<Rank, Int>> {
        val winningData = mutableListOf<Map<Rank, Int>>()

        val resultRankData = lotties.mapNotNull {
            it.getResultForEachLotto()
        }

        val ranks = Rank.entries.toTypedArray()

        for (rank in ranks) {
            winningData.add(mapOf(rank to resultRankData.count { it == rank }))
        }
    }

    fun getRateOfReturn(): Float {

    }

    fun List<Int>.getResultForEachLotto(): Rank? {
        val winningCount = getWinningCount(this)
        val containsBonus = getContainsBonusOrNot(this)

        return when (winningCount) {
            3 -> Rank.FIFTH
            4 -> Rank.FOURTH
            5 -> if (!containsBonus) Rank.THIRD else Rank.SECOND
            6 -> Rank.FIRST
            else -> null
        }
    }

    private fun getWinningCount(lotto: List<Int>): Int {
        var winningCount = 0
        lotto.onEach {
            if (it in winningNumbers) winningCount++
        }

        return winningCount
    }

    private fun getContainsBonusOrNot(lotto: List<Int>): Boolean = bonusNumber in lotto

}