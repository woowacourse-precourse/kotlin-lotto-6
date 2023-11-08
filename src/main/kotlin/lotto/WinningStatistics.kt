package lotto
enum class WinningPrize(val prize: Long) {
    NONE(0),
    THREE_MATCH(5_000),
    FOUR_MATCH(50_000),
    FIVE_MATCH(1_500_000),
    FIVE_MATCH_WITH_BONUS(30_000_000),
    SIX_MATCH(2_000_000_000);

    companion object {
        fun getPrizeForMatchedNumbers(matchedNumbers: Int): Long {
            return values().firstOrNull { it.ordinal + 2 == matchedNumbers }?.prize ?: 0
        }
    }
}

class WinningStatistics(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    fun checkWinningResult(lotto: Lotto): WinningPrize {
        val matchedNumbers = lotto.getMatchedNumbers(winningNumbers)
        val bonusMatched = lotto.containsNumber(bonusNumber)

        return when {
            matchedNumbers == 6 -> WinningPrize.SIX_MATCH
            matchedNumbers == 5 && bonusMatched -> WinningPrize.FIVE_MATCH_WITH_BONUS
            matchedNumbers == 5 -> WinningPrize.FIVE_MATCH
            matchedNumbers == 4 -> WinningPrize.FOUR_MATCH
            matchedNumbers == 3 -> WinningPrize.THREE_MATCH
            else -> WinningPrize.NONE
        }
    }

    fun calculatePrize(winningPrize: WinningPrize): Long {
        return winningPrize.prize
    }

    fun getPrizeString(prize: Long): String {
        return if (prize == 0L) {
            "꽝"
        } else {
            val formattedPrize = String.format("%,d", prize)
            "${formattedPrize}원"
        }
    }

    fun calculateTotalPrize(tickets: List<Lotto>): Long {
        var totalPrize = 0L
        for (ticket in tickets) {
            val winningPrize = checkWinningResult(ticket) // 검색 결과
            val prize = calculatePrize(winningPrize) // 결과 따른 prize
            totalPrize += prize
        }
        return totalPrize
    }

    fun calculateWinningRate(purchasedAmount: Int, totalPrize: Long): Double {
        if (purchasedAmount.toLong() == 0L) {
            return 0.0
        }
        return (totalPrize.toDouble() / purchasedAmount) * 100
    }

}

