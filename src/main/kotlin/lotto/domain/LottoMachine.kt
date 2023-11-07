package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val inputMoney: Int) {
    fun issueLottos(): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(inputMoney / 1000) {
            lottos.add(createLotto())
        }
        return lottos.toList()
    }

    private fun createLotto(): Lotto {
        return Lotto(generateNumbers())
    }

    private fun generateNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    fun calculateResult(lottos: List<Lotto>, winningLotto: WinningLotto): LottoResult {
        val result = LottoResult()

        for (lotto in lottos) {
            val matchingCount = winningLotto.checkCountMatched(lotto)
            val bonusMatch = winningLotto.checkBonusMatch(lotto)
            result.addCount(Rank.checkRank(matchingCount, bonusMatch))
        }
        return result
    }

    fun getRateOfReturn(result: LottoResult): Double {
        val totalPrize = calculateTotalPrize(result)
        return (totalPrize.toDouble() / inputMoney) * 100
    }

    private fun calculateTotalPrize(result: LottoResult): Int {
        return Rank.entries.sumOf { rank ->
            result.getCount(rank) * rank.getPrize(rank)
        }
    }
}