package util

object Calculator {
    private var winningAmount = 0L

    fun plusWinningAmount(rank: Int, count: Int) {
        when (rank) {
            PrizeRank.FIRST_PLACE.rank -> winningAmount += PrizeRank.FIRST_PLACE.amount * count
            PrizeRank.SECOND_PLACE.rank -> winningAmount += PrizeRank.SECOND_PLACE.amount * count
            PrizeRank.THIRD_PLACE.rank -> winningAmount += PrizeRank.THIRD_PLACE.amount * count
            PrizeRank.FOURTH_PLACE.rank -> winningAmount += PrizeRank.FOURTH_PLACE.amount * count
            PrizeRank.FIFTH_PLACE.rank -> winningAmount += PrizeRank.FIFTH_PLACE.amount * count
        }
    }

    fun getProfitPercentage(principal: Int) = (winningAmount / 1000).toFloat() / principal * 100
    enum class PrizeRank(val rank: Int, val amount: Long) {
        FIRST_PLACE(1, 2_000_000_000L),
        SECOND_PLACE(2, 30_000_000L),
        THIRD_PLACE(3, 1_500_000L),
        FOURTH_PLACE(4, 50_000L),
        FIFTH_PLACE(5, 5_000L),
    }
}
