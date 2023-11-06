package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class Lottos(private val amount: Int) {
    private val lottos = ArrayList<Lotto>()
    private fun generateNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    fun generateLottos() {
        for (i in 1..amount) {
            lottos.add(Lotto(generateNumber()))
        }
    }

    fun getLottoRanks(winningNumber: List<Int>, bonusNumber: Int): Map<Rank, Int> {
        val rankCounts = Rank.values().associateWith { 0 }.toMutableMap()
        for (lotto in lottos) {
            val rank = lotto.getRank(winningNumber, bonusNumber)
            rankCounts[rank] = rankCounts[rank]!! + 1
        }
        return rankCounts
    }

    fun getLottos(): ArrayList<Lotto> {
        return lottos
    }
}