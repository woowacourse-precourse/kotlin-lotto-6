package lotto.model

import kotlin.math.round

class WinningResult(val result: Map<Rank, Int>) : Map<Rank, Int> by result {

    fun getReturnRate() : Double {
        val total = result.values.sum() * LOTTO_PRICE
        return (round(result.map {getSumMoney(it).toDouble() / total}.sum() * 10000) / 100)
    }

    private fun getSumMoney(e: Map.Entry<Rank, Int>): Int = e.key.winningMoney * e.value

    companion object {
        private const val LOTTO_PRICE = 1_000

        fun of(winningLotto: WinningLotto, userlottos: Lottos): WinningResult =
            WinningResult(
                Rank.values().associateWith { rank ->
                    userlottos.lottos.count {
                        rank == Rank.of(winningLotto.getMatchCnt(it), winningLotto.getMatchBonus(it))
                    }
                }
            )
    }
}
