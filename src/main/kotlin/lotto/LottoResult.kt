package lotto

import java.text.DecimalFormat

enum class LottoRank(val prize: Int, val prizeString: String) {
    FIRST(2_000_000_000, "2,000,000,000원"),
    SECOND(30_000_000, "30,000,000원"),
    THIRD(1_500_000, "1,500,000원"),
    FOURTH(50_000, "50,000원"),
    FIFTH(5_000, "5,000원"),
    NONE(0, "0원")
}

class LottoResult (private val lottos: List<Lotto>,
                   private val winningNumbers: List<Int>,
                   private val bonusNumber: Int) {
    private val rankCounts = mutableMapOf(5 to 0, 4 to 0, 3 to 0, 2 to 0, 1 to 0)

    init {
        checkMatches()
        printResult()
    }

    private fun checkMatches() {
        for (lotto in lottos) {
            val matchedCount = lotto.getNumbers().intersect(winningNumbers).count()
            val isBonusMatched = lotto.getNumbers().contains(bonusNumber)

            if (matchedCount == 6) {
                rankCounts[1] = rankCounts[1]!! + 1
            } else if (matchedCount == 5 && isBonusMatched) {
                rankCounts[2] = rankCounts[2]!! + 1
            } else if (matchedCount == 5) {
                rankCounts[3] = rankCounts[3]!! + 1
            } else if (matchedCount == 4) {
                rankCounts[4] = rankCounts[4]!! + 1
            } else if (matchedCount == 3) {
                rankCounts[5] = rankCounts[5]!! + 1
            }
        }
    }
    fun getRankCountsForTest(): Map<Int, Int> {
        return rankCounts
    }

    private fun printResult() {
        PrintText.printMessage(Constants.PRINT_WINNING_STATISTICS_MESSAGE, 0)
        printRate()
    }

    private fun printRate() {
        val decimal = DecimalFormat("#,###.0")
        val prizeAmount = calPrizeAmount()
        val totalPrizeRate = calPrizeRate(prizeAmount)

        PrintText.printRate(decimal.format(LottoMath.roundRate(totalPrizeRate)))
    }

    private fun calPrizeAmount(): Int {
        var result = 0

        for (rank in 5 downTo 1) {
            val count = rankCounts[rank]!!
            result += prize[rank]!! * count
            printMatchedNumber(rank, count)
        }
        return result
    }

    private fun calPrizeRate(prizeAmount: Int): Double {
         return (prizeAmount.toDouble() / (lottos.size * 1000)) * 100
    }

    private fun printMatchedNumber(rank: Int, count: Int) {
        val matchedNumber = getMatchedNumberFromRank(rank)
        val prizeDescription = LottoRank.values()[rank - 1].prizeString

        println(getResultText(rank, matchedNumber, prizeDescription, count))
    }
    private fun getMatchedNumberFromRank(rank: Int): Int {
        if (rank == 1 || rank == 2)
            return 7 - rank
        return 8 - rank
    }

    private fun getResultText(rank: Int, matchedNumber: Int, prizeDescription: String, count: Int): String {
        if (rank == Constants.WIN_WITH_BONUS)
            return "${matchedNumber}개 일치, 보너스 볼 일치 (${prizeDescription}) - ${count}개"
        return "${matchedNumber}개 일치 (${prizeDescription}) - ${count}개"
    }
    companion object {
        private val prize = mutableMapOf(
            5 to LottoRank.FIFTH.prize,
            4 to LottoRank.FOURTH.prize,
            3 to LottoRank.THIRD.prize,
            2 to LottoRank.SECOND.prize,
            1 to LottoRank.FIRST.prize
        )
    }
}