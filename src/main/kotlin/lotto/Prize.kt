package lotto

data class Prize(
    var first: Int = 0,
    var second: Int = 0,
    var third: Int = 0,
    var fourth: Int = 0,
    var fifth: Int = 0,
    var miss: Int = 0,
) {
    fun countPrize(rank: Rank) {
        when (rank.winningNumber) {
            Rank.FIRST_RANK.winningNumber -> first++
            Rank.SECOND_RANK.winningNumber -> second++
            Rank.THIRD_RANK.winningNumber -> third++
            Rank.FOURTH_RANK.winningNumber -> fourth++
            Rank.FIFTH_RANK.winningNumber -> fifth++
            else -> miss++
        }
    }

    fun getPrizeMoney(): Double {
        return (Rank.FIFTH_RANK.money * first
                + Rank.SECOND_RANK.money * second
                + Rank.THIRD_RANK.money * third
                + Rank.FOURTH_RANK.money * fourth
                + Rank.FIFTH_RANK.money * fifth)
    }
}
