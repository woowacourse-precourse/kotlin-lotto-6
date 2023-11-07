package lotto.model

class WinningStatics(
    winnings: List<Winning>,
    val profitPercentage: Double
) {
    private val countByWinning: Map<Winning, Int> = run {
        val result = mutableMapOf<Winning, Int>()
        val winningEnums = Winning.values()
        winningEnums.forEach { winningEnum ->
            val count = winnings.count { it == winningEnum }
            result[winningEnum] = count
        }
        return@run result
    }

    fun countOf(winning: Winning): Int {
        return requireNotNull(countByWinning[winning])
    }
}
