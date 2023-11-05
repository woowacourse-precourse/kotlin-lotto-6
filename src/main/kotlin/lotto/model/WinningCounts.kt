package lotto.model

import lotto.constants.WinningRank

class WinningCounts {
    private val resultStore = mutableMapOf<WinningRank, Int>()

    fun addCount(winningRank: WinningRank) {
        resultStore[winningRank] = resultStore.getOrDefault(winningRank, 0) + 1
    }

    operator fun get(winningRank: WinningRank) =
        resultStore.getOrDefault(winningRank, 0)
}