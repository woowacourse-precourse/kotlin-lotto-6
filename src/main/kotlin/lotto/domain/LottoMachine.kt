package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants.NUMBERS_SIZE
import lotto.Constants.NUMBER_END_RANGE
import lotto.Constants.NUMBER_START_RANGE

class LottoMachine(private val inputMoney: Int) {
    fun issueLottos(): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(inputMoney / LOTTO_PRICE) {
            lottos.add(createLotto())
        }
        return lottos.toList()
    }

    private fun createLotto(): Lotto {
        return Lotto(generateNumbers())
    }

    private fun generateNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(NUMBER_START_RANGE, NUMBER_END_RANGE, NUMBERS_SIZE)

    fun calculateResult(lottos: List<Lotto>, winningLotto: WinningLotto): LottoResult {
        val result = LottoResult()

        for (lotto in lottos) {
            val matchingCount = winningLotto.countMatchedNumbers(lotto)
            val bonusMatch = winningLotto.hasBonusNumber(lotto)
            result.updateCount(Rank.getRank(matchingCount, bonusMatch))
        }
        return result
    }

    fun getRateOfReturn(result: LottoResult): Double {
        val totalPrize = calculateTotalPrize(result)
        return (totalPrize.toDouble() / inputMoney) * PERCENTAGE_MULTIPLIER
    }

    private fun calculateTotalPrize(result: LottoResult): Int {
        return Rank.entries.sumOf { rank ->
            result.getRankCount(rank) * rank.getPrize(rank)
        }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val PERCENTAGE_MULTIPLIER = 100
    }
}