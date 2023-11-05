package lotto.model

import lotto.constants.WinningRank

class WinningCounts {
    private val resultStore = mutableMapOf<WinningRank, Int>()

    fun addCount(winningResult: WinningRank) {
        resultStore[winningResult] = resultStore.getOrDefault(winningResult, 0) + 1
    }

    operator fun get(winningRank: WinningRank) =
        resultStore.getOrDefault(winningRank, 0)
}