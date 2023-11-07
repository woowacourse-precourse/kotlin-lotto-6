package lotto

class LottoResult (private val lottos: List<Lotto>, private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    private val prize = mutableMapOf(5 to 5000, 4 to 50000, 3 to 1500000, 2 to 2000000000, 1 to 30000000)
    private val matchedCounts = mutableMapOf(5 to 0, 4 to 0, 3 to 0, 2 to 0, 1 to 0)

    init {
        checkMatches()
    }

    private fun checkMatches() {
        for (lotto in lottos) {
            val matchedCount = lotto.getNumbers().intersect(winningNumbers).count()
            val isBonusMatched = lotto.getNumbers().contains(bonusNumber)

            if (matchedCount == 6) {
                matchedCounts[1] = matchedCounts[1]!! + 1
            } else if (matchedCount == 5 && isBonusMatched) {
                matchedCounts[2] = matchedCounts[2]!! + 1
            } else if (matchedCount == 5) {
                matchedCounts[3] = matchedCounts[3]!! + 1
            } else if (matchedCount == 4) {
                matchedCounts[4] = matchedCounts[4]!! + 1
            } else if (matchedCount == 3) {
                matchedCounts[5] = matchedCounts[5]!! + 1
            }
        }
    }
    fun getMatchedCountsForTest(): Map<Int, Int> {
        return matchedCounts
    }
}