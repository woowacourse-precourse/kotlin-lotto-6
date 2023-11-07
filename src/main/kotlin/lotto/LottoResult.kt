package lotto

enum class LottoRank(val prize: Int, val prizeString: String) {
    FIRST(2_000_000_000, "2,000,000,000원"),
    SECOND(30_000_000, "30,000,000원"),
    THIRD(1_500_000, "1,500,000원"),
    FOURTH(50_000, "50,000원"),
    FIFTH(5_000, "5,000원"),
    NONE(0, "0원")
}

class LottoResult (private val lottos: List<Lotto>, private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    private val prize = mutableMapOf(5 to LottoRank.FIFTH.prize, 4 to LottoRank.FOURTH.prize, 3 to LottoRank.THIRD.prize, 2 to LottoRank.SECOND.prize, 1 to LottoRank.FIRST.prize)
    private val matchedCounts = mutableMapOf(5 to 0, 4 to 0, 3 to 0, 2 to 0, 1 to 0)

    init {
        checkMatches()
        printResult()
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

    private fun printResult() {
        PrintText.printMessage("PrintWinningStatistics", 0)
        var prizeAmount = 0
        for (rank in 1..5) {
            val count = matchedCounts[rank]!!
            prizeAmount += prize[rank]!! * count
            val matchedNumber = when(rank) {
                1 -> 6
                2 -> 5
                else -> 8 - rank
            }
            val prizeDescription = LottoRank.values()[rank - 1].prizeString
            when (rank) {
                2 -> println("${matchedNumber}개 일치, 보너스 볼 일치 (${prizeDescription}) - ${count}개")
                else -> println("${matchedNumber}개 일치 (${prizeDescription}) - ${count}개")
            }
        }
        val totalPrizeRate = ((prizeAmount.toDouble() / (lottos.size * 1000)) * 100)
        println(totalPrizeRate)
        println("총 수익률은 ${LottoMath.roundRate(totalPrizeRate)}%입니다.")
    }
}