package lotto.model

class WinningResult(val result: Map<Rank, Int>) : Map<Rank, Int> by result {

    companion object {
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
