package lotto.service

import lotto.constants.WinningRank
import lotto.model.*
import lotto.model.lotto.*

class WinningCalculator {
    fun calculateWinningResult(purchaseLottos: PurchaseLottos, winningLotto: WinningLotto): WinningResult {
        val winningCounts = WinningCounts()
        val winningAmount = WinningAmount()

        purchaseLottos.forEach { lotto ->
            val winningRank = getWinningRank(lotto, winningLotto)
            updateWinningCountsAndAmount(winningCounts, winningAmount, winningRank)
        }

        return WinningResult(winningCounts, winningAmount)
    }

    private fun getWinningRank(lotto: Lotto, winningLotto: WinningLotto): WinningRank {
        val count = lotto.countMatchingNumber(winningLotto.lotto)

        return when (count) {
            6 -> WinningRank.FIRST
            5 -> getWinningRankWhenFIVE(lotto, winningLotto.bonus)
            4 -> WinningRank.FOURTH
            3 -> WinningRank.FIFTH
            else -> WinningRank.NOT_WINNING
        }
    }

    private fun getWinningRankWhenFIVE(lotto: Lotto, bonus: Bonus): WinningRank {
        if (lotto.isMatchingBonus(bonus)) {
            return WinningRank.SECOND
        }
        return WinningRank.THIRD
    }

    private fun updateWinningCountsAndAmount(
        winningCounts: WinningCounts,
        winningAmount: WinningAmount,
        winningRank: WinningRank
    ) {
        if (isWinning(winningRank)) {
            winningCounts.addCount(winningRank)
            winningAmount.add(winningRank.amount)
        }
    }

    private fun isWinning(winningRank: WinningRank) = winningRank != WinningRank.NOT_WINNING

    fun calculateTotalReturn(winningAmount: WinningAmount, purchaseAmount: Int) =
        winningAmount.amount.toDouble() / purchaseAmount * 100
}