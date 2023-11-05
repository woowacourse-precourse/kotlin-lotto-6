package lotto.service

import lotto.constants.WinningRank
import lotto.model.*
import lotto.model.lotto.Bonus
import lotto.model.lotto.Lotto
import lotto.model.lotto.Lottos
import lotto.model.lotto.WinningLotto

class WinningCalculator {
    fun calculateWinningResult(lottos: Lottos, winningLotto: WinningLotto): WinningResult {
        val winningCounts = WinningCounts()
        val winningAmount = WinningAmount()

        lottos.forEach { lotto ->
            val winningResult = getWinningResult(lotto, winningLotto)
            updateWinningCountsAndAmount(winningCounts, winningAmount, winningResult)
        }

        return WinningResult(winningCounts, winningAmount)
    }

    private fun getWinningResult(lotto: Lotto, winningLotto: WinningLotto): WinningRank {
        val count = lotto.countMatchingNumber(winningLotto.lotto)

        return when (count) {
            6 -> WinningRank.FIRST
            5 -> getWinningResultWhenFIVE(lotto, winningLotto.bonus)
            4 -> WinningRank.FOURTH
            3 -> WinningRank.FIFTH
            else -> WinningRank.NOT_WINNING
        }
    }

    private fun getWinningResultWhenFIVE(lotto: Lotto, bonus: Bonus): WinningRank {
        if (lotto.isMatchingBonus(bonus)) {
            return WinningRank.SECOND
        }

        return WinningRank.THIRD
    }

    private fun updateWinningCountsAndAmount(winningCounts: WinningCounts, winningAmount: WinningAmount, winningResult: WinningRank) {
        if (isWinning(winningResult)) {
            winningCounts.addCount(winningResult)
            winningAmount.add(winningResult.amount)
        }
    }

    private fun isWinning(winningResult: WinningRank) = winningResult != WinningRank.NOT_WINNING

    fun calculateTotalReturn(winningAmount: WinningAmount, purchaseAmount: Int) =
        winningAmount.totalAmount.toDouble() / purchaseAmount * 100
}