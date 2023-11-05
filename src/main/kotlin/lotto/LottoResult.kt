package lotto

import java.util.*

class LottoResult(val lottos: MutableList<Lotto> = mutableListOf()) {

    lateinit var winLotto: Lotto

    internal fun countWinNumbers(lotto: Lotto): Int {
        return winLotto.toAscendingList()
            .intersect(lotto.toAscendingList().toSet())
            .size
    }


    enum class MatchNumber(val count: Int) {
        NO_MATCH(0),
        ONE_MATCH(1),
        TWO_MATCH(2),
        THREE_MATCH(3),
        FOUR_MATCH(4),
        FIVE_MATCH(5),
        SIX_MATCH(6)
    }
}
