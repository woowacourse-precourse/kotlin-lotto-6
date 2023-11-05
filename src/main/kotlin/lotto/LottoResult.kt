package lotto

import java.util.*

class LottoResult() {

    lateinit var winLotto: Lotto
    var bonus = 0

    fun countWinNumbers(lotto: Lotto): Int {
        return winLotto.toAscendingList()
            .intersect(lotto.toAscendingList().toSet())
            .size
    }
    fun hasBonus(): Boolean = winLotto.toAscendingList().contains(bonus)

    fun calculateWinLottos(lottos: MutableList<Lotto>) {
        for (lotto in lottos) {
            when (countWinNumbers(lotto)) {
                MatchNumber.THREE_MATCH.value ->  MatchNumber.THREE_MATCH.count++
                MatchNumber.FOUR_MATCH.value ->  MatchNumber.FOUR_MATCH.count++
                MatchNumber.FIVE_MATCH.value ->  MatchNumber.FIVE_MATCH.count++
                MatchNumber.SIX_MATCH.value ->  MatchNumber.SIX_MATCH.count++
            }
        }
    }

    enum class MatchNumber(val value: Int, var count: Int) {
        BONUS_MATCH(0, 0),
        THREE_MATCH(3, 0),
        FOUR_MATCH(4, 0),
        FIVE_MATCH(5, 0),
        SIX_MATCH(6, 0);
    }
}
