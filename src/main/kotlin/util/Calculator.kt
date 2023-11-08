package util

object Calculator {
    private var winningAmount = 0L

    fun plusWinningAmount(rank: Int, count: Int) {
        when (rank) {
            PrizeMessageRank.FIRST.rank -> winningAmount += PrizeMessageRank.FIRST.prize * count
            PrizeMessageRank.SECOND.rank -> winningAmount += PrizeMessageRank.SECOND.prize * count
            PrizeMessageRank.THIRD.rank -> winningAmount += PrizeMessageRank.THIRD.prize * count
            PrizeMessageRank.FOURTH.rank -> winningAmount += PrizeMessageRank.FOURTH.prize * count
            PrizeMessageRank.FIFTH.rank -> winningAmount += PrizeMessageRank.FIFTH.prize * count
        }
    }

    fun clearWinningAmountValue() {
        winningAmount = 0L
    }

    fun getProfitPercentage(principal: Int) = (winningAmount / LottoConfiguration.TICKET_PRICE.value).toFloat() / principal * 100
}
