package lotto.model

import lotto.utils.Constants

class Money(val purchasedMoney: Int) {
    val countOfPurchasedLotto: Int
        get() = purchasedMoney / Constants.MONEY_UNIT

    init {
        require(purchasedMoney >= Constants.MIN_MONEY) { Constants.PURCHASED_MONEY_MIN_ERROR_MESSAGE }
        require(purchasedMoney % Constants.MONEY_UNIT == Constants.MIN_MONEY) { Constants.PURCHASED_MONEY_UNIT_ERROR_MESSAGE }
    }

    fun calculateEarningsRate(winningStatistic: Map<WinningRank, Int>): Float {
        val totalWinningMoney = calculateTotalWinningMoney(winningStatistic)
        return totalWinningMoney / purchasedMoney * 100
    }

    private fun calculateTotalWinningMoney(winningStatistic: Map<WinningRank, Int>): Float {
        var sum = 0f
        winningStatistic.forEach { (winningRank, countByWinningRank) ->
            sum += winningRank.prizeMoney * countByWinningRank
        }
        return sum
    }
}